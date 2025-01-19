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

/**
 *
 * @author admin1711
 */
public class EmployeeDAO extends DBContext {
    
    public List<Employee> getAll(){
        ServiceProviderDAO sd  = new ServiceProviderDAO();
        RoleDAO rd = new RoleDAO();
        String sql="select * from employee";
        List<Employee> list = new ArrayList<>();
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
                ServiceProvider sp =sd.getById(rs.getString("companyId"));
                String startDate = rs.getDate("startDate").toString();
                String endDate = rs.getDate("endDate")==null?"None":rs.getDate("enddate").toString();
                int status = rs.getInt("status");
                String username  =rs.getString("username");
                String password  =rs.getString("password");
                Role r= rd.getById(rs.getString("roleid"));
                Employee e = new Employee(id, name, bod, Email, phone, address, cccd, sp, startDate, endDate, status, username, password, r);
                list.add(e);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Employee> getAllWorkingEmployee(){
        ServiceProviderDAO sd  = new ServiceProviderDAO();
        RoleDAO rd = new RoleDAO();
        String sql="select * from employee where status=1";
        List<Employee> list = new ArrayList<>();
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
                ServiceProvider sp =sd.getById(rs.getString("companyId"));
                String startDate = rs.getDate("startDate").toString();
                String endDate = rs.getDate("endDate")==null?"None":rs.getDate("enddate").toString();
                int status = rs.getInt("status");
                String username  =rs.getString("username");
                String password  =rs.getString("password");
                Role r= rd.getById(rs.getString("roleid"));
                Employee e = new Employee(id, name, bod, Email, phone, address, cccd, sp, startDate, endDate, status, username, password, r);
                list.add(e);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Employee getById(String id){
        List<Employee> list = this.getAll();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)) return list.get(i);
        }
        return null;
    }
    
    public List<Account> getAllEmployeeAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "select username, password, email, id, roleId from Employee";
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

    
    public void EditProfileEm(String id,String phone, String email, String address){
        String sql="update Employee set Email=?, Phone=?, [Address]=? where id=?";
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
    
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        System.out.println(dao.getAll().size());
        System.out.println(dao.getById("E1001"));
    }
}
