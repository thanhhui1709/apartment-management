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
public class RequestDAO extends DBContext {

    public List<Request> getAll() {
        String sql = "select * from Request";
        List<Request> list = new ArrayList<>();
        ResidentDAO rd = new ResidentDAO();
        StaffDAO sd = new StaffDAO();
        RequestTypeDAO rtd = new RequestTypeDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                Resident r = rd.getById(rs.getString("rid"));
                Staff s = sd.getById(rs.getString("sid"));
                String detail = rs.getString("detail");
                String response = rs.getString("response");
                String date = rs.getDate("date").toString();
                String responseDate;
                if(rs.getDate("responseDate")==null){
                    responseDate=null;
                }
                else{
                    responseDate=rs.getDate("responseDate").toString();
                }
                String status = rs.getString("status");
                RequestType rt = rtd.getById(rs.getString("tid"));
                Request rq = new Request(id, r, s, detail, response, date, responseDate, status, rt);
                list.add(rq);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Request> getRequestByRoles(int role) {
        String sql = "select Request.Id as id,rId,sid,detail,Response,date,responsedate,Request.Status as status, tId ,roleId from Request join Staff on Request.[sId]=Staff.Id  ";
        List<Request> list = new ArrayList<>();
        ResidentDAO rd = new ResidentDAO();
        StaffDAO sd = new StaffDAO();
        RequestTypeDAO rtd = new RequestTypeDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if(role == rs.getInt("roleId")){
                String id = rs.getString("id");
                Resident r = rd.getById(rs.getString("rid"));
                Staff s = sd.getById(rs.getString("sid"));
                String detail = rs.getString("detail");
                String response = rs.getString("response");
                String date = rs.getDate("date").toString();
                String responseDate;
                if(rs.getDate("responseDate")==null){
                    responseDate=null;
                }
                else{
                    responseDate=rs.getDate("responseDate").toString();
                }
                String status = rs.getString("status");
                RequestType rt = rtd.getById(rs.getString("tid"));
                Request rq = new Request(id, r, s, detail, response, date, responseDate, status, rt);
                list.add(rq);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Request> getRequestByStatus(int statu) {
        String sql = "select * from Request where status=?";
        List<Request> list = new ArrayList<>();
        ResidentDAO rd = new ResidentDAO();
        StaffDAO sd = new StaffDAO();
        RequestTypeDAO rtd = new RequestTypeDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, statu);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                Resident r = rd.getById(rs.getString("rid"));
                Staff s = sd.getById(rs.getString("sid"));
                String detail = rs.getString("detail");
                String response = rs.getString("response");
                String date = rs.getDate("date").toString();
                String responseDate;
                if(rs.getDate("responseDate")==null){
                    responseDate=null;
                }
                else{
                    responseDate=rs.getDate("responseDate").toString();
                }
                String status = rs.getString("status");
                RequestType rt = rtd.getById(rs.getString("tid"));
                Request rq = new Request(id, r, s, detail, response, date, responseDate, status, rt);
                list.add(rq);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public int addRequest(String rId, String detail, RequestType rt) {
        StaffDAO sd = new StaffDAO();
        List<Request> list = this.getAll();
        Util util = new Util();
        String sql = "insert into request(id,rid,sid,detail,date,status,tid) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "R" + util.getNumberFromTextPlusOne(list.get(list.size() - 1).getId()));
            st.setString(2, rId);
            st.setString(3, sd.getByRequestType(rt).getId());
            st.setString(4, detail);
            st.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            st.setString(6, "No response");
            st.setString(7, rt.getId());
            st.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public List<Request> getPageByNumber(List<Request> list, int page, int number) {
        List<Request> listpage = new ArrayList<>();
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
    public List<Request> getByStatus(List<Request> list, int status) {
        List<Request> ls = this.getRequestByStatus(status);
        List<Request> sl = new ArrayList<>();
        for (Request l : ls ) {
            for (Request request : list) {
                if(l.getId().equals(request.getId())){
                    sl.add(request);
                }
            }
        }
        return sl;
    }
    public List<Request> getByRoles(List<Request> list, int role) {
        List<Request> ls = this.getRequestByRoles(role);
        List<Request> sl = new ArrayList<>();
        for (Request l : ls ) {
            for (Request request : list) {
                if(l.getId().equals(request.getId())){
                    sl.add(request);
                }
            }
        }
        return sl;
    }

    public static void main(String[] args) {
        RequestDAO dao = new RequestDAO();
        List<Request> list = new ArrayList<>();
        list=dao.getAll();
        list = dao.getByRoles(list, 5);
        System.out.println(list.size());
    }
}
