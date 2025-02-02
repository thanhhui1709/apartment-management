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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    public List<Feedback> getFeedbackByRole(String role) {
        FeedbackDAO dao = new FeedbackDAO();
        List<Feedback> list = dao.getAllFeedback();
        List<Feedback> listFeedbackGetByRole = new ArrayList<>();
        if (role.equals("2")) {
            return list;
        }
        for (Feedback f : list) {
            if (f.getRequestType().getDestination().getId().equals(role)) {
                listFeedbackGetByRole.add(f);
            }
        }
        return listFeedbackGetByRole;
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

    public List<Feedback> getByResidentName(List<Feedback> listFeedback, String name) {
        String sql = "select * from Feedback f join Resident r on r.Id = f.rId  where name like '%" + name + "%'";
        List<Feedback> list = new ArrayList<>();
        ResidentDAO daoR = new ResidentDAO();
        RequestTypeDAO daoRT = new RequestTypeDAO();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feedback(rs.getString("id"),
                        rs.getString("detail"),
                        rs.getString("date"),
                        daoR.getById(rs.getString("rid")),
                        daoRT.getById(rs.getString("tid"))));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Feedback> getByDate(List<Feedback> listFeedback, String startDate, String endDate) {
        String sql = "select * from Feedback where date ";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (startDate != null) {
            Date date = Date.valueOf(startDate);
            String formatDate = format.format(date);
            sql += ">= '" + formatDate + "'";
        }
        if (endDate != null) {
            Date date = Date.valueOf(endDate);
            String formatDate = format.format(date);
            sql += " and date <= '" + formatDate + "'";
        }
        List<Feedback> list = new ArrayList<>();
        ResidentDAO daoR = new ResidentDAO();
        RequestTypeDAO daoRT = new RequestTypeDAO();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feedback(rs.getString("id"),
                        rs.getString("detail"),
                        rs.getString("date"),
                        daoR.getById(rs.getString("rid")),
                        daoRT.getById(rs.getString("tid"))));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Feedback> getByServiceType(List<Feedback> listFeedback, String serviceId) {
        String sql = "select * from Feedback where tid = '" + serviceId + "'";
        List<Feedback> list = new ArrayList<>();
        ResidentDAO daoR = new ResidentDAO();
        RequestTypeDAO daoRT = new RequestTypeDAO();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feedback(rs.getString("id"),
                        rs.getString("detail"),
                        rs.getString("date"),
                        daoR.getById(rs.getString("rid")),
                        daoRT.getById(rs.getString("tid"))));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Feedback> getPageByNumber(List<Feedback> list, int page, int number) {
        List<Feedback> listpage = new ArrayList<>();
        int start = number * (page - 1);
        int end = number * page - 1;
        for (int i = start; i <= end; i++) {
            listpage.add(list.get(i));
            if (i == list.size() - 1) {
                break;
            }
        }
        return listpage;
    }

    public static void main(String[] args) {
        FeedbackDAO dao = new FeedbackDAO();
//        System.out.println(dao.getAllFeedback().size());
        System.out.println(dao.getByServiceType(dao.getAllFeedback(), "R004").size());

        // Define the date format
    }
}
