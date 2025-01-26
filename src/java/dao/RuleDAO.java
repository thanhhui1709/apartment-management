/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import jdbc.DBContext;
import model.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Rule;
import util.Util;

/**
 *
 * @author quang
 */
public class RuleDAO extends DBContext {

    public List<Rule> getAllRule() {
        List<Rule> listRule = new ArrayList<>();
        StaffDAO daoS = new StaffDAO();
        String sql = "select * from [Rule]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listRule.add(new Rule(rs.getString("id"), rs.getString("title"),
                        rs.getString("description"), rs.getDate("date").toString(),
                        rs.getDate("effectivedate").toString(), rs.getString("status"), daoS.getById(rs.getString("sid"))));
            }
            return listRule;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean insertRule(Rule rule) {
        String sql = "insert into [Rule] (id, title,description,date, effectivedate,status,sid) values(?,?,?,?,?,?,?)";
        Util u = new Util();
        RuleDAO daoR = new RuleDAO();
        List<Rule> listRule = daoR.getAllRule();
        int lastNum = 0;
        if(listRule.size() != 0){
            lastNum = u.getNumberFromTextOnlyNumber(listRule.get(listRule.size()-1).getId());
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, (lastNum+1)+"");
            ps.setString(2, rule.getTitle());
            ps.setString(3, rule.getDescription());
            ps.setString(4, rule.getDate());
            ps.setString(5, rule.getEffectiveDate());
            ps.setString(6, rule.getStatus().equalsIgnoreCase("1") ? "Active" : "Inactive");
            ps.setString(7, rule.getStaff().getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RuleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        RuleDAO dao = new RuleDAO();
        StaffDAO daoS = new StaffDAO();
        System.out.println(dao.getAllRule().size());
    }
}
