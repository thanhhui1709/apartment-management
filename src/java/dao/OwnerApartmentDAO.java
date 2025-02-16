/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jdbc.DBContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Apartment;
import model.LivingApartment;
import model.OwnerApartment;
import model.Resident;
/**
 *
 * @author thanh
 */
public class OwnerApartmentDAO extends DBContext {
    public static void main(String[] args) {
        OwnerApartmentDAO od = new OwnerApartmentDAO();
        System.out.println(od.getByApartmentID("A01_01").size());
    }
    public List<OwnerApartment> getByApartmentID(String aid){
        String sql = "select * from AparmentOwner where aId=?";
        ResidentDAO rd= new ResidentDAO();
        List<OwnerApartment> list= new ArrayList<>();
        ApartmentDAO ad = new ApartmentDAO();
        try {
            PreparedStatement st= connection.prepareStatement(sql);
            st.setString(1, aid);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                Resident re = rd.getById(rs.getString("rid"));
                Apartment a = ad.getById(aid);
                String startDate = rs.getDate("startDate").toString();
                String endDate;
                if(rs.getDate("enddate")==null){
                    endDate = null;
                }
                else endDate = rs.getDate("enddate").toString();
                int status = rs.getInt("status");
                OwnerApartment oa = new OwnerApartment(id, re, a, startDate, endDate, status);
                list.add(oa);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
