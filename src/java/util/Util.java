/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


import dao.ResidentDAO;
import dao.StaffDAO;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author thanh
 */
public class Util {

    public String getTableNameByRoleId(int role) {
        String destination = "";
        switch (role) {
            case 3:
                destination = "employee";
                break;
            case 1:
                destination = "resident";
                break;
            case 4:
                destination = "render";
                break;
            default:
                destination = "staff";
                break;
        }
        return "view-profile-" + destination;
    }
    public  String getTableNameByRoleIdEdit(int role){
        if(role==1) return "editprofileRE.jsp";
        return "editprofileST.jsp";
    }
    public String getSiteToViewRule(int role){
        if(role==1) return "view-rule-resident";
        return "view-rule-admin";
    }
    
    public String getSiteToViewRequest(int role){
        if(role==1) return "viewrequest_history";
        return "view-all-request";
    }
    
    public String getSiteToViewFeedBack(int role){
        if(role==1) return "view-feed-back-user";
        return "view-all-feedback";
    }
    
    public int getNumberFromText(String str) {
        return Integer.parseInt(str.substring(1));
    }
    
     public int getNumberFromTextOnlyNumber(String str) {
        return Integer.parseInt(str);
    }
    public int getNumberFromTextPlusOne(String str) {
        return Integer.parseInt(str.substring(1))+1;
    }
    public static void main(String[] args) {
        Util u=new  Util();
    }
    public Date convertStringToDate(String str){
       String[] number=str.split("-");
          Date date = new Date(Integer.parseInt(number[0]), Integer.parseInt(number[1]), Integer.parseInt(number[2]));
       return date;
    }
    public List<String> getAllEmail(){
        StaffDAO sd = new StaffDAO();
        ResidentDAO rd = new ResidentDAO();
        List<String> rs = new ArrayList<>();
        for (int i = 0; i < sd.getAll().size(); i++) {
            rs.add(sd.getAll().get(i).getEmail());
        }
        for (int i = 0; i < rd.getAll().size(); i++) {
            rs.add(rd.getAll().get(i).getEmail());
        }
        return rs;
    }
}
