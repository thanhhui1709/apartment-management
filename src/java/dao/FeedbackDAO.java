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

    public int sendFeedback(String detail, String rID, String tID) {
        String sql = "INSERT INTO [dbo].[Feedback]\n"
                + "           ([Id]\n"
                + "           ,[Detail]\n"
                + "           ,[Date]\n"
                + "           ,[rId]\n"
                + "           ,[tId])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        List<Feedback> list = getAllFeedback();
        String lastID = list.get(list.size() - 1).getId();

        // Convert java.util.Date to java.sql.Date
        Util u = new Util();
        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);
        int newIDNumber = u.getNumberFromTextPlusOne(lastID);
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "F" + newIDNumber);
            st.setString(2, detail);
            st.setDate(3, sqlDate);
            st.setString(4, rID);
            st.setString(5, tID);
            st.executeUpdate();
            return 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public static void main(String[] args) {
        FeedbackDAO dao = new FeedbackDAO();
        System.out.println(dao.getAllFeedback().size());
        System.out.println(dao.sendFeedback("nhu cec", "P100", "R001"));

        // Define the date format
    }
}
