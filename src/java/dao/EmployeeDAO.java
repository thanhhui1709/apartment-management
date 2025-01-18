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
                Employee e = new Employee(id, name, bod, Email, phone, address, cccd, Email, startDate, endDate, status, username, password, r);
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

    //-----------------------------------------------------------------------ACCOUNTDAO-----------------------------------------------------
    
    
    public List<Account> getAllAccount() {
        ResidentDAO daoR = new ResidentDAO();
        StaffDAO daoS = new StaffDAO();
        EmployeeDAO daoE = new EmployeeDAO();

        List<Account> list = new ArrayList<>();
        list.addAll(daoR.getAllResidentAccount());
        list.addAll(daoS.getAllStaffAccount());
        list.addAll(daoE.getAllEmployeeAccount());

        return list;
    }

    public Account getAccountById(String pId) {
        EmployeeDAO dao = new EmployeeDAO();
        List<Account> list = dao.getAllAccount();
        for (Account a : list) {
            if (a.getpId().equals(pId)) {
                return a;
            }
        }
        return null;
    }

    public Account getAccountByUsername(String username) {
        EmployeeDAO dao = new EmployeeDAO();
        List<Account> list = dao.getAllAccount();
        for (Account a : list) {
            if (a.getUsername().equals(username)) {
                return a;
            }
        }
        return null;
    }

    public void changePassword(String username, String password, int roleId) {
        String sql = "Update ";
        if (roleId == 1) {
            sql += "Resident set password = ? where username = ? ";
        } else if (roleId == 2) {
            sql += "Staff set password = ? where username = ? ";
        } else {
            sql += "Employee set password = ? where username = ? ";
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        System.out.println(dao.getAll().size());
        System.out.println(dao.getById("E1001"));
    }
}
