/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Apartment;
import model.Floor;
import model.RoomType;

/**
 *
 * @author Lenovo
 */
public class ApartmentDAO extends DBContext {

    public List<Apartment> getViewApartment(String floor, String type, String status) {
        String sql = "select * from Apartment";
        if (!floor.equals("") || !type.equals("") || !status.equals("")) {
            sql += " where id <> 'A00_00' ";
        }
        if (!floor.equals("")) {
            sql += "and floor = " + floor;
        }
        if (!type.equals("")) {
            sql += "and rtid = " + "'" + type + "'";
        }
        if (!status.equals("")) {
            sql += "and status = " + status;
        }
        List<Apartment> list = new ArrayList<>();
        FloorDAO fdao = new FloorDAO();
        RoomTypeDAO rdao = new RoomTypeDAO();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Apartment(rs.getString("id"), rs.getInt("noperson"),
                        fdao.getByNumber(rs.getInt("floor")), rs.getString("information"),
                        rdao.getRoomTypeById(rs.getString("rtid")), rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e + "abcsda");
        }
        return list;
    }

    public boolean getApartmentByRoomType(int id) {
        String sql = "select * from RoomType rt join Apartment a on a.rtId=rt.Id where rt.Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;

    }

    public Apartment getById(String id) {
        String sql = "select * from Apartment where id=?";
        List<Apartment> list = new ArrayList<>();
        RoomTypeDAO rtd = new RoomTypeDAO();
        FloorDAO fd = new FloorDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int noPerson = rs.getInt("Noperson");
                Floor floor = fd.getByNumber(rs.getInt("floor"));
                String information = rs.getString("information");
                RoomType rt = rtd.getRoomTypeById(rs.getString("rtId"));
                int status = rs.getInt("status");
                Apartment a = new Apartment(id, noPerson, floor, information, rt, status);
                return a;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public boolean insertNewApartment(Apartment newApartment) {
        String sql = "INSERT INTO [dbo].[Apartment]\n"
                + "           ([Id]\n"
                + "           ,[NoPerson]\n"
                + "           ,[floor]\n"
                + "           ,[information]\n"
                + "           ,[rtId]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newApartment.getId());
            st.setInt(2, newApartment.getNumberOfPerson());
            st.setInt(3, newApartment.getFloor().getNumber());
            st.setString(4, newApartment.getInfor());
            st.setString(5, newApartment.getRoomtype().getId());
            st.setInt(6, newApartment.getStatus());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean checkExistAptNumber(String number) {
        String sql = "Select * from Apartment where Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, number);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        ApartmentDAO dao = new ApartmentDAO();
        RoomTypeDAO rtf = new RoomTypeDAO();
        FloorDAO fd = new FloorDAO();
        Floor floor = fd.getByNumber(1);
        RoomType roomType = rtf.getRoomTypeById("1");
        Apartment apt=new Apartment("A124", 2, floor, "hehe", roomType, 1);
        System.out.println(dao.insertNewApartment(apt));

    }
}
