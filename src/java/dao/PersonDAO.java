/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DBContext;
/**
 *
 * @author thanh
 */
public class PersonDAO extends DBContext{
    public List<Person> getAll(){
        String sql= "select * from person";
        List<Person> list= new ArrayList<>();
        try {
            PreparedStatement st= connection.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                String id= rs.getString("id");
                String name = rs.getString("fullname");
                String bod = rs.getDate("Bod").toString();
                String email = rs.getString("email");
                String sdt = rs.getString("sđt");
                String address = rs.getString("address");
                String cccd=rs.getString("cccd");
                Person p = new Person(id, name, bod, email, sdt, address, cccd);
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Person getById(String id){
        List<Person> all = this.getAll();
        for (int i = 0; i < all.size(); i++) {
            if(all.get(i).getId().equals(id)) return all.get(i);
        }
        return null;
    }
}
