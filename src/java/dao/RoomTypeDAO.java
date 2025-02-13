/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jdbc.DBContext;
import java.util.List;
import model.Resident;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DBContext;
import model.Account;
import model.Role;
import util.Util;
import model.Account;
import model.Role;

import model.Role;
import model.RoomType;

/**
 *
 * @author quang
 */
public class RoomTypeDAO extends DBContext {

    public String generateID() {
        String sql = "select id from roomtype";
        List<Integer> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(Integer.parseInt(rs.getString(1)));
            }
            return (Collections.max(list) + 1) + "";
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<RoomType> getAll() {
        String sql = "select * from Roomtype";
        RoomTypeDAO dao = new RoomTypeDAO();
        List<RoomType> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new RoomType(rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("maxperson"),
                        rs.getInt("bedroom"),
                        rs.getInt("livingroom"),
                        rs.getInt("bathroom"),
                        rs.getInt("balcony"),
                        rs.getFloat("square")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean checkExistNameRoomType(String name) {
        String sql = "select * from RoomType where name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insertRoomType(RoomType r) {
        String sql = "insert into RoomType (id, name,maxperson, square, bedroom, livingroom, bathroom, balcony)\n"
                + "values(?,?,?,?,?,?,?,?)";
        RoomTypeDAO dao = new RoomTypeDAO();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dao.generateID());
            ps.setString(2, r.getName());
            ps.setInt(3, r.getLimitPerson());
            ps.setFloat(4, r.getSquare());
            ps.setInt(5, r.getBedroom());
            ps.setInt(6, r.getLivingRoom());
            ps.setInt(7, r.getBathRoom());
            ps.setInt(8, r.getBalcony());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        RoomTypeDAO dao = new RoomTypeDAO();
        RoomType r = new RoomType("1", "Deluxe Suite", 4, 2, 1, 2, 1, 500.0f);
        System.out.println(dao.checkExistNameRoomType("Deluxe Suite"));
    }
}
