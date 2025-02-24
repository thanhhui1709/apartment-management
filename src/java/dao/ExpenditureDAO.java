/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Company;
import model.Expenditure;
import model.Staff;

/**
 *
 * @author PC
 */
public class ExpenditureDAO extends DBContext{
    public List<Expenditure> getAll(){
        List<Expenditure> list = new ArrayList<>();
        String sql = "select * from Expenditure";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                String approveddate = rs.getString("aproveddate");
                String paymentdate = rs.getString("paymentdate");
                String note = rs.getString("note");
                String category = rs.getString("category");
                CompanyDAO cdao = new CompanyDAO();
                StaffDAO sdao = new StaffDAO();
                Company company = cdao.getById(rs.getString("cid"));
                Staff staff = sdao.getById(rs.getString("sid"));
                Expenditure ne = new Expenditure(id, amount, price, approveddate, paymentdate, note, category, company, staff);
                list.add(ne);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
