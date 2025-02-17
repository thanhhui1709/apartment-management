/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import jdbc.DBContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DBContext;
import model.Apartment;
import model.Contract;
import model.Floor;
import model.RoomType;

/**
 *
 * @author quang
 */
public class ContractDAO extends DBContext {

    public List<Contract> getAll() {
        String sql = "select * from Contract";
        CompanyDAO daoCP = new CompanyDAO();
        StaffDAO daoSt = new StaffDAO();
        List<Contract> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Contract(daoSt.getById(rs.getString("sId")),
                        daoCP.getById("cId"),
                        rs.getString("enddate"),
                        rs.getString("Startdate"),
                        rs.getString("paymenttems"),
                        rs.getString("signdate"),
                        rs.getString("title"),
                        rs.getString("Description"),
                        rs.getInt("status")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Contract> filterContract(String title, String startDate, String endDate) {
        String sql = "select * from Contract where 1 = 1 ";
        CompanyDAO daoCP = new CompanyDAO();
        StaffDAO daoSt = new StaffDAO();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (title != "") {
            sql += "and title = '%" + title + "%'";
        }
        if (startDate != "") {
            Date date = Date.valueOf(startDate);
            String formatDate = format.format(date);
            sql += " and startdate >= '" + formatDate + "'";
        }

        if (endDate != "") {
            Date date = Date.valueOf(endDate);
            String formatDate = format.format(date);
            sql += " and enddate>= '" + formatDate + "'";
        }
        List<Contract> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Contract(daoSt.getById(rs.getString("sId")),
                        daoCP.getById("cId"),
                        rs.getString("enddate"),
                        rs.getString("Startdate"),
                        rs.getString("paymenttems"),
                        rs.getString("signdate"),
                        rs.getString("title"),
                        rs.getString("Description"),
                        rs.getInt("status")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ContractDAO dap = new ContractDAO();
        System.out.println(dap.filterContract("", "", "2025-2-17").size());
    }
}
