/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import jdbc.DBContext;

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

    public static void main(String[] args) {
        ApartmentDAO dao = new ApartmentDAO();
        System.out.println(dao.getApartmentByRoomType(4));
    }
}
