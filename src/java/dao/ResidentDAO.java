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
import model.Role;
import util.Util;
import model.Account;
import model.Role;

import model.Role;

/**
 *
 * @author thanh
 */

public class ResidentDAO extends DBContext {

    public boolean checkConnection() {
        return connection == null;
    }

    public List<Resident> getAll() {
        String sql = "select  * from resident";

        List<Resident> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String bod = rs.getDate("bod").toString();
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String cccd = rs.getString("cccd");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Role role = new Role("1", "resident", "keke");
                list.add(new Resident(id, name, cccd, phone, email, bod, address, username, password, email, name, role));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResidentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Resident getById(String pid) {
        List<Resident> all = this.getAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getpId().equals(pid)) {
                return all.get(i);
            }
        }
        return null;
    }

    public String getEmailByUserName(String username) {
        String sql = "select email from Resident where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ResidentDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Account> getAllResidentAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "select username, password, email, id, roleId from Resident";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                list.add(a);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ResidentDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void changPasswordById(String id, String newpw){
        String sql="update resident set password = ? where id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newpw);
            st.setString(2 , id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
<<<<<<< Updated upstream
=======

//    Resident(String pId, String name, String cccd, String phone, String email, String bod, String address, String status)
    public List<Resident> getAllResident() {
        String sql = "select * from Resident r right join Apartment a\n"
                + "on r.Id = a.rId ";
        List<Resident> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Resident(rs.getString("id"), rs.getString("Name"),
                        rs.getString("cccd"), rs.getString("phone"),
                        rs.getString("email"), rs.getString("email"), rs.getString("address"), rs.getString("status")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ResidentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertNewResident(String name, String address, String email, String phone, String bod, String id, String username, String password) {
        String sql = "INSERT INTO [dbo].[Resident]\n"
                + "           ([Id]\n"
                + "           ,[Name]\n"
                + "           ,[Bod]\n"
                + "           ,[Email]\n"
                + "           ,[Phone]\n"
                + "           ,[Address]\n"
                + "           ,[CCCD]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[roleId])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?)";
        Util u = new Util();
        List<Resident> listResident = getAll();
        int lastID = u.getNumberFromText(listResident.get(listResident.size() - 1).getpId());
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "P" + (lastID + 1));
            st.setString(2, name);
            st.setString(3, bod);
            st.setString(4, email);
            st.setString(5, phone);
            st.setString(6, address);
            st.setString(7, id);
            st.setString(8, username);
            st.setString(9, password);
            st.setInt(10, 1);
            st.executeUpdate();
            return 0;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public static void main(String[] args) {
        ResidentDAO dao = new ResidentDAO();
        List<Resident> listResident = dao.getAll();

        Util u = new Util();
        int lastID = u.getNumberFromText(listResident.get(listResident.size() - 1).getpId());
        System.out.println(lastID);
        dao.insertNewResident("thanh", "abcd", "hui@gmail.com", "021331213", "1999-05-12", "001204035477", "hui", "123");
    }
>>>>>>> Stashed changes
}
