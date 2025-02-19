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
import java.sql.Date;
import java.time.LocalDate;
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
        String sql = "select * from Request order by date";
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
                if (rs.getDate("responseDate") == null) {
                    responseDate = null;
                } else {
                    responseDate = rs.getDate("responseDate").toString();
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
                if (role == rs.getInt("roleId")) {
                    String id = rs.getString("id");
                    Resident r = rd.getById(rs.getString("rid"));
                    Staff s = sd.getById(rs.getString("sid"));
                    String detail = rs.getString("detail");
                    String response = rs.getString("response");
                    String date = rs.getDate("date").toString();
                    String responseDate;
                    if (rs.getDate("responseDate") == null) {
                        responseDate = null;
                    } else {
                        responseDate = rs.getDate("responseDate").toString();
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

    public List<Request> getRequestByStatus(String statu) {
        String sql = "select * from Request where status=?";
        List<Request> list = new ArrayList<>();
        ResidentDAO rd = new ResidentDAO();
        StaffDAO sd = new StaffDAO();
        RequestTypeDAO rtd = new RequestTypeDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, statu);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                Resident r = rd.getById(rs.getString("rid"));
                Staff s = sd.getById(rs.getString("sid"));
                String detail = rs.getString("detail");
                String response = rs.getString("response");
                String date = rs.getDate("date").toString();
                String responseDate;
                if (rs.getDate("responseDate") == null) {
                    responseDate = null;
                } else {
                    responseDate = rs.getDate("responseDate").toString();
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

    public void AssignRequest(String requestid, String staffid) {
        String sql = "update Request set sid = ? , Status = 'In process' , Response = 'In process' where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, staffid);
            st.setString(2, requestid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Request> getPageByNumber(List<Request> list, int page, int number) {
        List<Request> listpage = new ArrayList<>();
        int start = number * (page - 1);
        int end = number * page - 1;
        if(list.isEmpty()) return null;
        for (int i = start; i <= end; i++) {
            listpage.add(list.get(i));
            if (i == list.size() - 1) {
                break;
            }
        }
        return listpage;
    }

    public List<Request> getByStatus(List<Request> list, String status) {
        List<Request> ls = this.getRequestByStatus(status);
        List<Request> sl = new ArrayList<>();
        if(list.isEmpty()) return null;
        for (Request l : ls) {
            for (Request request : list) {
                if (l.getId().equals(request.getId())) {
                    sl.add(request);
                }
            }
        }
        return sl;
    }
    
    public List<Request> getWaitingTable(List<Request> list) {
        List<Request> sl = new ArrayList<>();
        for (Request request : list) {
            if(request.getStatus().equalsIgnoreCase("No response") || request.getStatus().equalsIgnoreCase("Waiting")){
                sl.add(request);
            }
        }
        return sl;
    }
    
    public List<Request> getInProcessgTable(List<Request> list) {
        List<Request> sl = new ArrayList<>();
        for (Request request : list) {
            if(request.getStatus().equalsIgnoreCase("In process")){
                sl.add(request);

            }
        }
        return sl;
    }
    
    public List<Request> getDoneTable(List<Request> list) {
        List<Request> sl = new ArrayList<>();
        for (Request request : list) {
            if(request.getStatus().equalsIgnoreCase("Done")){
                sl.add(request);
            }
        }
        return sl;
    }

    public List<Request> getByRoles(List<Request> list, int role) {
        List<Request> ls = this.getRequestByRoles(role);
        List<Request> sl = new ArrayList<>();
        for (Request l : ls) {
            for (Request request : list) {
                if (l.getId().equals(request.getId())) {
                    sl.add(request);
                }
            }
        }
        return sl;
    }

    public List<Request> getByResidentID(String id) {
        List<Request> result = new ArrayList<>();
        List<Request> getAllRequest = getAll();
        for (Request request : getAllRequest) {
            if (request.getResidentId().getpId().equals(id)) {
                result.add(request);
            }
        }
        return result;

    }

    public List<Request> getByResidentIDAndDate(String id, String from, String to, String requestType) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Request WHERE rId = ?");
        List<Request> list = new ArrayList<>();
        ResidentDAO rd = new ResidentDAO();
        StaffDAO sd = new StaffDAO();
        RequestTypeDAO rtd = new RequestTypeDAO();

        // Handle optional parameters
        if (from != null && to != null) {
            sql.append(" AND (date BETWEEN ? AND ?)");
        }
        if (requestType != null && !requestType.isEmpty()) {
            sql.append(" AND tId = ?");
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql.toString());
            st.setString(1, id);

            int paramIndex = 2;
            if (from != null && to != null) {
                st.setString(paramIndex++, from);
                st.setString(paramIndex++, to);
            }
            if (requestType != null && !requestType.isEmpty()) {
                st.setString(paramIndex++, requestType);
            }

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resident r = rd.getById(id);
                Staff s = sd.getById(rs.getString("sid"));
                String detail = rs.getString("detail");
                String response = rs.getString("response");
                String date = rs.getDate("date").toString();
                String responseDate = rs.getDate("responseDate") != null ? rs.getDate("responseDate").toString() : null;
                String status = rs.getString("status");
                RequestType rt = rtd.getById(rs.getString("tid"));
                Request rq = new Request(id, r, s, detail, response, date, responseDate, status, rt);
                list.add(rq);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logger for real applications
        }
        return list;
    }

    public List<String> getAllRequestByStatus(String status) {
        List<String> list = new ArrayList<>();
        String sql = " select * from request where status=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                list.add(id);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Request getById(String id) {
        String sql = "select * from Request order by date";
        ResidentDAO rd = new ResidentDAO();
        StaffDAO sd = new StaffDAO();
        RequestTypeDAO rtd = new RequestTypeDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Resident r = rd.getById(rs.getString("rid"));
                Staff s = sd.getById(rs.getString("sid"));
                String detail = rs.getString("detail");
                String response = rs.getString("response");
                String date = rs.getDate("date").toString();
                String responseDate;
                if (rs.getDate("responseDate") == null) {
                    responseDate = null;
                } else {
                    responseDate = rs.getDate("responseDate").toString();
                }
                String status = rs.getString("status");
                RequestType rt = rtd.getById(rs.getString("tid"));
                Request rq = new Request(id, r, s, detail, response, date, responseDate, status, rt);
                return rq;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public void declineRequestWithoutMessageById(String id){
        String sql="update request set Response='Decline', status='Done', responsedate=? where id=?";
        LocalDate date = LocalDate.now();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1, Date.valueOf(date));
            st.setString(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        RequestDAO dao = new RequestDAO();
        List<Request> list = new ArrayList<>();
        list = dao.getAll();
//        list = dao.getAll();
//        list = dao.getByRoles(list, 5);
//        List<Request> getByRID = dao.getByResidentIDAndDate("P110", "2025-01-01", "2025-01-25", "R001");
//        System.out.println(getByRID.get(0).getRequestType().getName());
        System.out.println(""+list);
        System.out.println(""+dao.getInProcessgTable(list));
        dao.AssignRequest("R005", "S1005");
        System.out.println(dao.getAllRequestByStatus("waiting").size());

    }
}
