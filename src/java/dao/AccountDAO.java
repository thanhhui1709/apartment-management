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
import jdbc.DBContext;
import model.Account;

/**
 *
 * @author PC
 */
public class AccountDAO extends DBContext{
    
    public List<Account> getAll() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Account ";
        //thuc thi cau truy van
        try {
            PreparedStatement pre = connection.prepareCall(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                int role = rs.getInt("Role");
                Account ac = new Account(username, password, role);
                list.add(ac);
            }
        } catch (SQLException e) {
            System.out.println("" + e);
        }
        return list;
    }
    
    public Account getAccountByUsername(String user) {
        String sql = "SELECT * FROM Account WHERE [username]=?";
        Account s = null;
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, user);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                s = new Account();
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setRole(rs.getInt("Role"));
            }
        } catch (SQLException e) {
            System.out.println("" + e);
        }
        return s;
    }
    public static void main(String[] args) {
        AccountDAO s = new AccountDAO();
        Account c = s.getAccountByUsername("user1");
        System.out.println(""+c.getUsername()+c.getPassword());
    }
}
