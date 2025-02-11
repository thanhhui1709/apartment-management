/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import jdbc.DBContext;
import model.CategoryService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author thanh
 */
public class CategoryServiceDAO extends DBContext {
    public List<CategoryService> getAll(){
        String sql="select * from ServiceCategory";
        List<CategoryService> list = new ArrayList<>();
        try {
            PreparedStatement st= connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String detail  =rs.getString("detail");
                CategoryService cs= new CategoryService(id, name, detail);
                list.add(cs);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
