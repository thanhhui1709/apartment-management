/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jdbc.DBContext;
import model.Expenditure;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class ExpenditureDAO extends DBContext {

    public boolean updateExpenditure(Expenditure e) {
        String sql = "UPDATE [dbo].[Expenditure]\n"
                + "   SET ?,?,?,?,?,?,?,?,?\n"
                + " WHERE Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, e.getId());
            st.setInt(2, e.getAmount());
            st.setFloat(3, e.getPrice());
            st.setString(4, e.getAprroveddate());
            st.setString(5, e.getPaymentdate());
            st.setString(6, e.getNote());
            st.setString(7, e.getCategory());
            st.setString(8, e.getCid());
            st.setString(9, e.getSid());
            st.setString(10, e.getId());
            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;

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
