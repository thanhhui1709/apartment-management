/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Staff;

/**
 *
 * @author thanh
 */
public class AdminDAO extends DBContext {
    public List<Staff> getAllStaffExceptAdmin(){
        StaffDAO sd = new StaffDAO();
        List<Staff> all = sd.getAll();
        List<Staff> rs = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if(!all.get(i).getRole().getId().equals("4")) rs.add(all.get(i));
        }
        return rs;
    }
}
