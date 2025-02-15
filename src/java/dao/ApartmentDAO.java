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

                RoomType roomtype = rt.getRoomTypeByApartmentId(rs.getString("id"));

                Floor floor = new Floor();
                floor.setNumber(rs.getInt("floor"));

                Apartment apartment = new Apartment(rs.getString("Id"),
                        rs.getInt("NoPerson"),
                        floor,
                        rs.getString("information"),roomtype
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
    }
}
