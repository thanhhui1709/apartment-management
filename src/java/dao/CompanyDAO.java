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
/**
 *
 * @author thanh
 */
public class CompanyDAO extends DBContext{
    public List<Company> getAll(){
        List<Company> list = new ArrayList<>();
        String sql = "select * from Company";
        try {
            PreparedStatement st =connection.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String name =rs.getString("name");
                String description = rs.getString("description");
                String sdt = rs.getString("sdt");
                String email =rs.getString("email");
                String address =rs.getString("address");
                Company sp = new Company(id, name, description, sdt, email, address);
                list.add(sp);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Company getById(String id){
        List<Company> all =this.getAll();
        for (int i = 0; i < all.size(); i++) {
            if(all.get(i).getId().equals(id)) return all.get(i);
        }
        return null;
    }
    
    public List<Company> searchCompaniesbyName(String name){
        List<Company> list = this.getAll();
        List<Company> sc  = new ArrayList<>();
        if(name.isBlank()){
            return list;
        }else{
           for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().toLowerCase().contains(name.toLowerCase())) sc.add(list.get(i));
            } 
        }
        return sc;
    }
    public List<Company> getPageByNumber(List<Company> list,int page,int number){
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
    
    public boolean inserNewCompany(Company com){
        String sql ="insert into Company(id,name,description,sdt,email,address)\n"
                +"Values(?,?,?,?,?,?)";
        List<Company> list = this.getAll();
        
        int lastIdNum = 1; 
    if (!list.isEmpty()) {
        String lastId = list.get(list.size() - 1).getId();
        lastIdNum = Integer.parseInt(lastId.substring(1)) + 1; 
    }
    String newId = String.format("C%03d", lastIdNum);
    try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newId);
            ps.setString(2, com.getName());
            ps.setString(3, com.getDescription());
            ps.setString(4, com.getSdt());
            ps.setString(5, com.getEmail());
            ps.setString(6, com.getAddress());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void main(String[] args) {
        CompanyDAO dao = new CompanyDAO();
        List<Company> list = dao.getAll();
        list=dao.getPageByNumber(list, 1, 3);
        list=dao.searchCompaniesbyName("ba vi");
        for (Company company : list) {
            System.out.println(""+company.getName());
        }       
        Company com = new Company("C003", "Guard Company", "Providing apartment security services", "0326003325", "nam@gmail.com", "Ha Noi");
        System.out.println(""+dao.inserNewCompany(com));
    }
}
