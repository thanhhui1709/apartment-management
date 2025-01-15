/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.DBContext;
import model.Account;

/**
 *
 * @author PC
 */
public class AccountDAO extends DBContext {
    public Account getAccountByUsernameandRole(String user,int role) {
        String sql = null;
        if(role == 1){
            sql = "SELECT * FROM Resident WHERE [username]=?";
        }else if(role == 2){
            sql = "SELECT * FROM Staff WHERE [username]=?";
        }else if(role == 3){
            sql = "SELECT * FROM Employee WHERE [username]=?";
        }    
        Account s = null;
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, user);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                s = new Account(rs.getString("username"), rs.getString("password"), rs.getString("Email"), rs.getString("Id"), rs.getInt("roleId"));
            }
        } catch (SQLException e) {
            System.out.println("" + e);
        }
        return s;
    }
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        Account c = dao.getAccountByUsernameandRole("david", 1);
        System.out.println(""+c.getEmail());
    }
}
