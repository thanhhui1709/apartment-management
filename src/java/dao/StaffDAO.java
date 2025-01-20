/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Resident;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DBContext;
import model.Account;
import model.Employee;
import model.Role;
import model.ServiceProvider;
import model.Staff;

/**
 *
 * @author admin1711
 */
public class StaffDAO extends DBContext {
    
    public List<Staff> getAll(){
        ServiceProviderDAO sd  = new ServiceProviderDAO();
        RoleDAO rd = new RoleDAO();
        String sql="select * from Staff";
        List<Staff> list = new ArrayList<>();
        try {
            PreparedStatement st= connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("Name");
                String bod = rs.getDate("bod").toString();
                String Email = rs.getString("email");
                String phone = rs.getString("phone");
                String address =rs.getString("address");
                String cccd=rs.getString("cccd");
                int salary = rs.getInt("salary");
                String education = rs.getString("education");
                String bank =rs.getString("bank");
                String username  =rs.getString("username");
                String password  =rs.getString("password");
                Role r= rd.getById(rs.getString("roleid"));
                Staff s = new Staff(id, name, bod, Email, phone, address, cccd, salary, education, bank, username, password, r);
                list.add(s);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Staff getById(String id){
        List<Staff> list = this.getAll();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)) return list.get(i);
        }
        return null;
    }
    public void EditProfileSt(String id,String phone, String email, String address){
        String sql="update Staff set Email=?, Phone=?, [Address]=? where id=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, phone);
            pre.setString(3, address);
            pre.setString(4, id);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<Account> getAllStaffAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "select username, password, email, id,roleId from Staff";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ResidentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public int updateStaffInfor(String id,String name, String bod, String phone, String address, String cccd, String education, String bank) {
        String sql = "UPDATE [dbo].[Staff]\n"
                + "   SET \n"
                + "      [Name] = ?\n"
                + "      ,[Bod] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[CCCD] = ?\n"
                + "      ,[Education] = ?\n"
                + "      ,[Bank] = ?\n"
                + "     \n"
                + " WHERE ID=?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, bod);
            st.setString(3, phone);
            st.setString(4, address);
            st.setString(5, cccd);
            st.setString(6, education);
            st.setString(7, bank);
            st.setString(8, id);
            st.executeUpdate();
            return 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;

    }
}
