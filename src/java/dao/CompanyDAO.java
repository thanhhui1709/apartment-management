/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Company;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;

/**
 *
 * @author thanh
 */
public class CompanyDAO extends DBContext {

    public List<Company> getAll() {
        List<Company> list = new ArrayList<>();
        String sql = "select * from Company";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String contactphone = rs.getString("contactphone");
                String fax = rs.getString("fax");
                String email = rs.getString("email");
                String contactEmail = rs.getString("contactemail");
                String website = rs.getString("website");
                String taxCode = rs.getString("taxcode");
                String bank = rs.getString("bank");
                String description = rs.getString("description");
                String address = rs.getString("address");
                Company cp = new Company(id, name, phone, contactphone, fax, email, contactEmail, website, taxCode, bank, description, address);
                list.add(cp);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Company getById(String id) {
        List<Company> all = this.getAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId().equals(id)) {
                return all.get(i);
            }
        }
        return null;
    }

    public List<Company> searchCompaniesbyName(String name) {
        List<Company> list = this.getAll();
        List<Company> sc = new ArrayList<>();
        if (name.isBlank()) {
            return list;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                    sc.add(list.get(i));
                }
            }
        }
        return sc;
    }

    public List<Company> getPageByNumber(List<Company> list, int page, int number) {
        List<Company> listpage = new ArrayList<>();
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

//    id, name, phone, contactphone, fax, email, website, taxCode, bank, description, address
    public boolean insertNewCompany(Company com) {
        String sql = "insert into Company(id,name,phone,contactphone,fax,email,contactemail,website,taxcode,bank,description,address)\n"
                + "Values(?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Company> list = this.getAll();
        Util u = new Util();
        String newId = "";
        if (list.isEmpty()) {
            newId = "C001";
        } else {
            int lastIdNum = u.getNumberFromText(list.get(list.size() - 1).getId()) + 1;
            if (lastIdNum <= 9) {
                newId = "C00" + lastIdNum;
            } else if (lastIdNum >= 10 && lastIdNum <= 99) {
                newId = "C0" + lastIdNum;
            } else {
                newId = "C" + lastIdNum;
            }
        }

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newId);
            ps.setString(2, com.getName());
            ps.setString(3, com.getPhone());
            ps.setString(4, com.getContactPhone());
            ps.setString(5, com.getFax());
            ps.setString(6, com.getEmail());
            ps.setString(7, com.getContactemail());
            ps.setString(8, com.getWebsite());
            ps.setString(9, com.getTaxCode());
            ps.setString(10, com.getBank());
            ps.setString(11, com.getdescription());
            ps.setString(12, com.getAddress());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void updateCompany(Company company){
        String sql = "update company set name=?, phone=?,contactphone=?,fax=?,email=?,contactemail=?,"
                + "website=?,taxcode=?,bank=?,description=?,address=?"
                + " where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        CompanyDAO dao = new CompanyDAO();
        Company cp = new Company("324ss", "09113467", "091231247", "142322312", "caon4cass@gmail.com", "caon2s4ca@gmail.com", "xx",
                "c4scccwc",
                "12143813", "", "agfffsf");
        System.out.println(dao.insertNewCompany(cp));
    }
}
