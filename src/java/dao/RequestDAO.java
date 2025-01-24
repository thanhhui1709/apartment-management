/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jdbc.DBContext;
import model.RequestType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Request;
import model.Resident;
import model.Role;
import model.Staff;
import util.Util;
/**
 *
 * @author thanh
 */
public class RequestDAO extends DBContext{
    public List<Request> getAll(){
        String sql = " select * from request";
        List<Request> list = new ArrayList<>();
        ResidentDAO rd = new ResidentDAO();
        StaffDAO sd = new StaffDAO();
        RequestTypeDAO rtd  = new RequestTypeDAO();
        try {
            PreparedStatement st  = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            String idd =rs.getString("id");
            Resident r = rd.getById(rs.getString("rid"));
            Staff s  = sd.getById(rs.getString("sid"));
            String detail =rs.getString("detail");
            String date  =rs.getDate("date").toString();
            String responseDate = rs.getDate("responseDate").toString();
            String status = rs.getString("status");
            RequestType rt = rtd.getById(rs.getString("tid"));
            Request rq = new Request(idd, r, s, detail, responseDate, date, responseDate, status, rt);
            list.add(rq);
        } catch (Exception e) {
        }
        return list;
    }
    public void addRequest(String rId,String detail,RequestType rt){
        StaffDAO sd= new StaffDAO();
        List<Request> list= this.getAll();
        Util util = new Util();
        String sql = "insert into request(id,rid,sid,detail,date,status,tid) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement st =connection.prepareStatement(sql);
            st.setString(1, "R"+util.getNumberFromText(list.get(list.size()-1).getId()));
            st.setString(2, rId);
            st.setString(3, sd.getByRequestType(rt).getId());
            st.setString(4, detail);
            st.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            st.setString(6, "No response");
            st.setString(7, rt.getId());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
