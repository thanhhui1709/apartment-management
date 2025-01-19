/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DBContext;
import model.Account;
import util.Util;

/**
 *
 * @author thanh
 */
public class AccountDAO extends DBContext {

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        String a = dao.getcheckTable("alice", 3);
        System.out.println("" + a);
    }

    public String getcheckTable(String user, int roleId) {
        String check_table_1 = null;
        String check_table_2 = null;
        String check_table_3 = null;
        check_table_1 = "SELECT * FROM Resident WHERE [username]=? and [roleId]=?";
        check_table_2 = "SELECT * FROM Staff WHERE [username]=? and [roleId]=?";
        check_table_3 = "SELECT * FROM Employee WHERE [username]=? and [roleId]=?";
        String table = null;
        try {
            PreparedStatement pre_1 = connection.prepareStatement(check_table_1);
            pre_1.setString(1, user);
            pre_1.setInt(2, roleId);
            ResultSet rs_1 = pre_1.executeQuery();
            PreparedStatement pre_2 = connection.prepareStatement(check_table_2);
            pre_2.setString(1, user);
            pre_2.setInt(2, roleId);
            ResultSet rs_2 = pre_2.executeQuery();
            PreparedStatement pre_3 = connection.prepareStatement(check_table_3);
            pre_3.setString(1, user);
            pre_3.setInt(2, roleId);
            ResultSet rs_3 = pre_3.executeQuery();
            if (rs_2.next()) {
                table = "Staff";
            } else if (rs_1.next()) {
                table = "Resident";
            } else if (rs_3.next()) {
                table = "Employee";
            } else {
                table = "Empty";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResidentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }

    public Account getAccountByUsernameandRole(String user, int roleId) {
        String sql = null;
        Account s = null;
        AccountDAO dao = new AccountDAO();
        String table = null;
        table = dao.getcheckTable(user, roleId);
        if (table.equals("Empty")) {
            return s;
        } else if (table.equals("Resident")) {
            sql = "SELECT * FROM Resident WHERE [username]=?";
        } else if (table.equals("Staff")) {
            sql = "SELECT * FROM Staff WHERE [username]=?";
        } else if (table.equals("Employee")) {
            sql = "SELECT * FROM Employee WHERE [username]=?";
        }
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, user);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                s = new Account(rs.getString("username"), rs.getString("password"), rs.getString("Email"), rs.getString("Id"), rs.getInt("roleId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResidentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public void changePassword(String username, String password, int roleId) {
        String sql = "Update ";
        if (roleId == 1) {
            sql += "Resident set password = ? where username = ? ";
        } else if (roleId == 3) {
            sql += "Employee set password = ? where username = ? ";
        } else {
            sql += "Staff set password = ? where username = ? ";
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

    public Account getByEmail(String email) {
        Util util = new Util();
        List<Account> list = this.getAllAccount();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equals(email)) {
                return list.get(i);
            }
        }
        return null;
    }

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
        AccountDAO dao = new AccountDAO();
        List<Account> list = dao.getAllAccount();
        for (Account a : list) {
            if (a.getpId().equals(pId)) {
                return a;
            }
        }
        return null;
    }

    public Account getAccountByUsername(String username) {
        AccountDAO dao = new AccountDAO();
        List<Account> list = dao.getAllAccount();
        for (Account a : list) {
            if (a.getUsername().equals(username)) {
                return a;
            }
        }
        return null;
    }

}
