/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.response.FloorResponseDTO;
import jdbc.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Floor;
import util.Util;

/**
 *
 * @author thanh
 */
public class FloorDAO extends DBContext {

    //Hiển thị cần cả : số người ở, số phòng đang sử dụng, số phòng trống
    public List<FloorResponseDTO> getAll() {
        String sql = " select * from floor";
        List<FloorResponseDTO> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int floor = rs.getInt("floor");
                int square = rs.getInt("Square");
                String usagetype = rs.getString("usagetype");
                String note = rs.getString("note");
                int numberPerson = this.GetNumberLivingPersonFloor(floor);
                int numberUsingRoom = this.GetNumberUsingRoomByFloor(floor);
                int numberNotUsingRoom = this.GetNumberNoUsingRoomByFloor(floor);
                FloorResponseDTO floorResponseDTO = new FloorResponseDTO(floor, square, usagetype, note, numberPerson, numberUsingRoom, numberNotUsingRoom);
                list.add(floorResponseDTO);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public int GetNumberUsingRoomByFloor(int floor) {
        String sql = " select count(*) as numberofroom from floor f join apartment a on f.floor=a.floor where f.floor=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, floor);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("numberofroom");
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public int GetNumberNoUsingRoomByFloor(int floor) {
        String sql = " select count(*) as numberofroom from floor f join apartment a on f.floor=a.floor where f.floor=? and a.status=0";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, floor);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("numberofroom");
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public Floor Getfloorbyapartment(String apartmentId) {
    String sql = "SELECT F.floor, F.Square, F.usagetype, F.note " +
                 "FROM Apartment A " +
                 "JOIN Floor F ON A.floor = F.floor " +
                 "WHERE A.Id = ?";
    
    PreparedStatement pre = null;
    ResultSet rs = null;
    
    try {
        pre = connection.prepareStatement(sql);
        pre.setString(1, apartmentId);  // Đặt giá trị cho A.Id
        rs = pre.executeQuery();
        
        if (rs.next()) {  // Nếu có kết quả
            // Tạo đối tượng Floor và gán các thuộc tính
            Floor floor = new Floor(
                rs.getInt("floor"),       // floor number
                rs.getFloat("Square"),      // diện tích
                rs.getString("usagetype"),// loại sử dụng
                rs.getString("note")      // ghi chú
            );
            return floor;
        }
    } catch (Exception e) {
        e.printStackTrace();  // In lỗi để dễ debug
    } finally {
        // Đảm bảo đóng ResultSet và PreparedStatement
        try {
            if (rs != null) rs.close();
            if (pre != null) pre.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    return null;  // Trả về null nếu không tìm thấy
}

    
    public int GetNumberLivingPersonFloor(int floor) {
        String sql = "select f.floor,COALESCE(SUM(a.NoPerson), 0) as numberofperson "
                + "from floor f left join apartment a on f.floor=a.floor group by f.floor having f.floor=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, floor);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("numberofperson");
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public List<String> getAllUsageType() {
        String sql = "select distinct(usagetype) from Floor";
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String type = rs.getString("usageType");
                list.add(type);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<FloorResponseDTO> getByNumberFloor(int floor) {
        String sql = "select  * from floor where floor=?";
        List<FloorResponseDTO> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, floor);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int square = rs.getInt("Square");
                String usagetype = rs.getString("usagetype");
                String note = rs.getString("note");
                int numberPerson = this.GetNumberLivingPersonFloor(floor);
                int numberUsingRoom = this.GetNumberUsingRoomByFloor(floor);
                int numberNotUsingRoom = this.GetNumberNoUsingRoomByFloor(floor);
                FloorResponseDTO floorResponseDTO = new FloorResponseDTO(floor, square, usagetype, note, numberPerson, numberUsingRoom, numberNotUsingRoom);
                list.add(floorResponseDTO);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<FloorResponseDTO> getByUsageType(String type) {
        String sql = "select  * from floor where usagetype=?";
        List<FloorResponseDTO> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, type);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int floor = rs.getInt("floor");
                int square = rs.getInt("Square");
                String note = rs.getString("note");
                int numberPerson = this.GetNumberLivingPersonFloor(floor);
                int numberUsingRoom = this.GetNumberUsingRoomByFloor(floor);
                int numberNotUsingRoom = this.GetNumberNoUsingRoomByFloor(floor);
                FloorResponseDTO floorResponseDTO = new FloorResponseDTO(floor, square, type, note, numberPerson, numberUsingRoom, numberNotUsingRoom);
                list.add(floorResponseDTO);
            }
        } catch (SQLException e) {
        }
        return list;
    }

      public Floor getByNumber(int number){
          String sql="select * from floor where floor =?";
          try {
              PreparedStatement st= connection.prepareStatement(sql);
              st.setInt(1, number);
              ResultSet rs= st.executeQuery();
              while(rs.next()){
                  float square = rs.getFloat("square");
                  String usage = rs.getString("usagetype");
                  String note= rs.getString("note");
                  Floor f = new Floor(number, square, usage, note);
                  return f;
              }
          } catch (SQLException e) {
          }
          return null;
      }
    public static void main(String[] args) {
        FloorDAO fd = new FloorDAO();
        System.out.println(fd.getByNumber(2));
    }
}
