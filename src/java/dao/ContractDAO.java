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
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DBContext;
import model.Apartment;
import model.Contract;
import model.Floor;
import model.RoomType;

/**
 *
 * @author quang
 */
public class ContractDAO extends DBContext {

    public  List<Contract> getAll() {
        String sql = "select * from Contract";
        CompanyDAO daoCP = new CompanyDAO();
        StaffDAO daoSt = new StaffDAO();
        List<Contract> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Contract(daoSt.getById(rs.getString("sId")),
                        daoCP.getById("cId"),
                        rs.getString("startdate"),
                        rs.getString("enddate"),
                        rs.getString("paymenttems"),
                        rs.getString("signdate"),
                        rs.getString("title"),
                        rs.getString("Description"),
                        rs.getInt("status")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        ContractDAO dap = new ContractDAO();
        System.out.println(dap.getAll().size());
    }
}
