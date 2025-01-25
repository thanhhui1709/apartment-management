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
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DBContext;
import model.Account;
import model.Employee;
import model.Role;
import model.Company;
import model.Feedback;
import model.RequestType;
import util.Util;

/**
 *
 * @author quang
 */
public class FeedbackDAO extends DBContext {

    public List<Feedback> getAllFeedback() {
        String sql = "select * from Feedback";
        ResidentDAO daoR = new ResidentDAO();
        RequestTypeDAO daoRT = new RequestTypeDAO();
        List<Feedback> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feedback(rs.getString("id"), rs.getString("detail"), rs.getString("date"), daoR.getById(rs.getString("rid")),
                        daoRT.getById(rs.getString("tid"))));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Feedback> getAllFeedbackUser(String residentID) {
    String sql = "SELECT * FROM Feedback WHERE rId = ?";
    ResidentDAO daoR = new ResidentDAO();
    RequestTypeDAO daoRT = new RequestTypeDAO();
    List<Feedback> list = new ArrayList<>();

    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, residentID); 
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Resident resident = daoR.getById(rs.getString("rId"));
            RequestType requestType = daoRT.getById(rs.getString("tId"));

            Feedback feedback = new Feedback(
                rs.getString("id"), 
                rs.getString("detail"), 
                rs.getString("date"), 
                resident,
                requestType
            );
            list.add(feedback);
        }

        return list;
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return new ArrayList<>(); 
}

    
    public static void main(String[] args) {
        FeedbackDAO dao  = new FeedbackDAO();
        System.out.println(dao.getAllFeedback().size());
    }
}
