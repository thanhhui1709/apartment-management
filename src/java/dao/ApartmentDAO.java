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
    
    public List<Apartment> getViewApartment(String floor, String type, String status){
        String sql = "select * from Apartment";
        if(!floor.equals("") || !type.equals("") || !status.equals("")) sql += " where id <> 'A00_00' ";
        if(!floor.equals("")) sql += "and floor = "+floor;
        if(!type.equals("")) sql += "and rtid = "+"'"+type+"'";
        if(!status.equals("")) sql += "and status = "+status;
        List<Apartment> list = new ArrayList<>();
        FloorDAO fdao = new FloorDAO();
        RoomTypeDAO rdao = new RoomTypeDAO();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(new Apartment(rs.getString("id"), rs.getInt("noperson"), 
                        fdao.getByNumber(rs.getInt("floor")), rs.getString("information"), 
                        rdao.getRoomTypeById(rs.getString("rtid")), rs.getInt("status")));
            }
        }catch(SQLException e){
            System.out.println(e+"abcsda");
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

    public List<Apartment> GetREApartment(String reId) {
        String sql = "SELECT A.*, RT.*\n"
                + "FROM AparmentOwner AO\n"
                + "JOIN Apartment A ON AO.aId = A.Id\n"
                + "JOIN RoomType RT ON A.rtId = RT.Id\n"
                + "WHERE AO.rId = ? ";

        RoomTypeDAO rt = new RoomTypeDAO();
        List<Apartment> list = new ArrayList<>();

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, reId);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                System.out.println("Number Of Person: " + rs.getInt("NoPerson"));
                System.out.println("Floor: " + rs.getInt("floor"));
                System.out.println("Information: " + rs.getString("information"));

//                RoomType roomtype = rt.getRoomTypeById(rs.getString("rId"));

                Floor floor = new Floor();
                floor.setNumber(rs.getInt("floor"));

                Apartment apartment = new Apartment(
                        rs.getInt("NoPerson"),
                        floor,
                        rs.getString("information")
                );
                list.add(apartment);
            }

            rs.close();
            pre.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public static void main(String[] args) {
        ApartmentDAO dao = new ApartmentDAO();
        System.out.println(dao.getApartmentByRoomType(4));
        System.out.println(dao.GetREApartment("P101"));
    public Apartment getById(String id){
        String sql  ="select * from Apartment where id=?";
        List<Apartment> list = new ArrayList<>();
        RoomTypeDAO rtd = new RoomTypeDAO();
        FloorDAO fd = new FloorDAO();
        try {
            PreparedStatement st= connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                int noPerson = rs.getInt("Noperson");
                Floor floor  =fd.getByNumber(rs.getInt("floor"));
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
    public static void main(String[] args) {
        ApartmentDAO dao = new ApartmentDAO();
        System.out.println(dao.getApartmentByRoomType(4));
        System.out.println(dao.getById("A01_01").getNumberOfPerson());
    }
}
