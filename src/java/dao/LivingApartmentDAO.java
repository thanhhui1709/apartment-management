/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jdbc.DBContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DBContext;
import model.Apartment;
import model.LivingApartment;
import model.OwnerApartment;
import model.Resident;

/**
 *
 * @author thanh
 */
public class LivingApartmentDAO extends DBContext {

    public List<LivingApartment> getByApartmentID(String aid) {
        String sql = "select * from LivingAparment where aId=?";
        ResidentDAO rd = new ResidentDAO();
        List<LivingApartment> list = new ArrayList<>();
        ApartmentDAO ad = new ApartmentDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, aid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                Resident re = rd.getById(rs.getString("rid"));
                Apartment a = ad.getById(aid);
                String startDate = rs.getDate("startDate").toString();
                String endDate;
                if (rs.getDate("enddate") == null) {
                    endDate = null;
                } else {
                    endDate = rs.getDate("enddate").toString();
                }
                int status = rs.getInt("status");
                LivingApartment la = new LivingApartment(id, re, a, startDate, endDate, status);
                list.add(la);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public LivingApartment getLivingResidentByApartmentID(String aid) {
        String sql = "select * from LivingAparment where aId= ? and status  = 1";
        ResidentDAO rd = new ResidentDAO();

        ApartmentDAO ad = new ApartmentDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, aid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                Resident re = rd.getById(rs.getString("rid"));
                Apartment a = ad.getById(aid);
                String startDate = rs.getDate("startDate").toString();
                String endDate;
                if (rs.getDate("enddate") == null) {
                    endDate = null;
                } else {
                    endDate = rs.getDate("enddate").toString();
                }
                int status = rs.getInt("status");
                LivingApartment la = new LivingApartment(id, re, a, startDate, endDate, status);
                return la;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String generateID() {
        String sql = "select id from LivingAparment";
        List<Integer> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(Integer.parseInt(rs.getString(1)));
            }
            return (Collections.max(list) + 1) + "";
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean insertLivingApartment(LivingApartment la) {
        String sql = "insert into LivingAparment(id,rid,aid,Startdate, Enddate, status) values(?,?,?,?,?,1)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, this.generateID());
            ps.setString(2, la.getRid().getpId());
            ps.setString(3, la.getAid().getId());
            ps.setString(4, la.getStartDate());
            ps.setString(5, la.getEndDate());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {

        }
        return false;
    }

    public boolean updateLivingApartment(LivingApartment la) {
        String sql = "update LivingAparment set Enddate = ?, status = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, la.getEndDate());
            ps.setInt(2, la.getStatus());
            ps.setString(3, la.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(LivingApartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        LivingApartmentDAO dao = new LivingApartmentDAO();
        ResidentDAO daoR = new ResidentDAO();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        String date = now.format(formatter);
        LivingApartment oa = dao.getLivingResidentByApartmentID("A001");
        Resident ownerResident = daoR.getById("P102");
        oa.setRid(ownerResident);
        oa.setEndDate(date);
        oa.setStatus(0);

        System.out.println(dao.updateLivingApartment(oa) + " " + oa.getId());
        oa.setStatus(1);
        oa.setEndDate(null);
        oa.setStartDate(date);
    }
}
