/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.ServiceProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author thanh
 */
public class ServiceProviderDAO extends DBContext{
    public List<ServiceProvider> getAll(){
        List<ServiceProvider> list = new ArrayList<>();
        String sql = "select * from serviceprovider";
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
                ServiceProvider sp = new ServiceProvider(id, name, description, sdt, email, address);
                list.add(sp);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ServiceProvider getById(String id){
        List<ServiceProvider> all =this.getAll();
        for (int i = 0; i < all.size(); i++) {
            if(all.get(i).getId().equals(id)) return all.get(i);
        }
        return null;
    }
}
