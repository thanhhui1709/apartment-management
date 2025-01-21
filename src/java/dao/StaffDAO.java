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
import util.Util;

/**
 *
 * @author admin1711
 */
public class StaffDAO extends DBContext {

    public List<Staff> getAll() {
        ServiceProviderDAO sd = new ServiceProviderDAO();
        RoleDAO rd = new RoleDAO();
        String sql = "select * from Staff";
        List<Staff> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("Name");
                String bod = rs.getDate("bod").toString();
                String Email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String cccd = rs.getString("cccd");
                int salary = rs.getInt("salary");
                String education = rs.getString("education");
                String bank = rs.getString("bank");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Role r = rd.getById(rs.getString("roleid"));
                Staff s = new Staff(id, name, bod, Email, phone, address, cccd, salary, education, bank, username, password, r);
                list.add(s);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Staff getById(String id) {
        List<Staff> list = this.getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public void EditProfileSt(String id, String phone, String email, String address) {
        String sql = "update Staff set Email=?, Phone=?, [Address]=? where id=?";
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

    public boolean insertStaff(Staff s) {
        String sql = "insert into Staff(id,Name, bod, email, phone, Address, cccd,Salary,Education,Bank,username,password,roleId) \n"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,2)";
        Util u = new Util();
        List<Staff> list = this.getAll();
        
        int lastIdNum = 1; // Giá trị mặc định nếu danh sách rỗng
    if (!list.isEmpty()) {
        String lastId = list.get(list.size() - 1).getId(); // Lấy ID cuối
        lastIdNum = Integer.parseInt(lastId.substring(1)) + 1; // Chuyển "S001" -> 1, tăng lên 2
    }
    String newId = String.format("S%03d", lastIdNum);
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newId);
            ps.setString(2, s.getName());
            ps.setString(3, s.getBod());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getPhone());
            ps.setString(6, s.getAddress());
            ps.setString(7, s.getCccd());
            ps.setInt(8, s.getSalary());
            ps.setString(9, s.getEducation());
            ps.setString(10, s.getBank());
            ps.setString(11, s.getUsername());
            ps.setString(12, s.getPassword());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
