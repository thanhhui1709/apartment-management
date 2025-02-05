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
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DBContext;
import model.Account;
import model.Employee;
import model.Role;
import model.Company;
import model.Feedback;
import model.News;
import model.RequestType;
import util.Util;

/**
 *
 * @author quang
 */
public class NewDAO extends DBContext {

    public List<News> getAllNews() {
        String sql = "select * from news";
        StaffDAO daoSt = new StaffDAO();
        List<News> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new News(rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("source"),
                        rs.getString("category"),
                        rs.getString("image"),
                        daoSt.getById(rs.getString("sid")),
                        rs.getString("date")));

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(NewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public News getNewById(String id) {
        String sql = "select * from news where id  = ?";
        StaffDAO daoSt = new StaffDAO();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                News n = new News(rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("source"),
                        rs.getString("category"),
                        rs.getString("image"),
                        daoSt.getById(rs.getString("sid")),
                        rs.getString("date"));
                return n;
            }

        } catch (SQLException ex) {
            Logger.getLogger(NewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<News> getOtherNews(String id) {
        String sql = "select * from news where id != ?";
        StaffDAO daoSt = new StaffDAO();
        List<News> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new News(rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("source"),
                        rs.getString("category"),
                        rs.getString("image"),
                        daoSt.getById(rs.getString("sid")),
                        rs.getString("date")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(NewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        NewDAO daoN = new NewDAO();
        System.out.println(daoN.getNewById("1").getDate());
    }
}
