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

/**
 *
 * @author admin1711
 */
public class EmployeeDAO extends DBContext {

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
        System.out.println(dao.getAccountByUsername("quang"));
    }
}
