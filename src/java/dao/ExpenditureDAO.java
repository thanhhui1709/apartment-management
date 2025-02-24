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
import java.util.ArrayList;
import java.util.List;
import model.Company;
import model.Staff;

/**
 *
 * @author Lenovo
 */
public class ExpenditureDAO extends DBContext {

    public boolean updateExpenditure(Expenditure e) {
        String sql = "UPDATE [dbo].[Expenditure] "
                + "SET amount=?, Price=?, ApprovedDate=?, PaymentDate=?, "
                + "note=?, category=?, cid=?, sId=? "
                + "WHERE Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, e.getAmount());
            st.setFloat(2, e.getPrice());
            st.setString(3, e.getAprroveddate());
            st.setString(4, e.getPaymentdate());
            st.setString(5, e.getNote());
            st.setString(6, e.getCategory());
            st.setString(7, e.getCid().getId());
            st.setString(8, e.getSid().getId());
            st.setString(9, e.getId()); // WHERE condition

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
        return false;
    }

    /**
     *
     * @author PC
     */
    public List<Expenditure> getAll() {
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
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Expenditure getById(String id) {
        String sql = "select * from Expenditure where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                String approveddate = rs.getString("Approveddate");
                String paymentdate = rs.getString("paymentdate");
                String note = rs.getString("note");
                String category = rs.getString("category");
                CompanyDAO cdao = new CompanyDAO();
                StaffDAO sdao = new StaffDAO();
                Company company = cdao.getById(rs.getString("cid"));
                Staff staff = sdao.getById(rs.getString("sid"));
                Expenditure e = new Expenditure(id, amount, price, approveddate, paymentdate, note, category, company, staff);
                return e;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        ExpenditureDAO ed = new ExpenditureDAO();
        Expenditure e = ed.getById("1");
        e.setAmount(100);
        System.out.println(ed.updateExpenditure(e));
    }
}
