/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author thanh
 */
public class Util {
    public  String getTableNameByRoleId(int role){
        String destination = "";
        switch (role) {
            case 3:
                destination= "employee";
                break;
            case 1:
                destination= "resident";
                break;
            case 4:
                destination= "render";
                break;
            default:
                destination="staff";
                break;
        }
        return "view-profile-"+destination;
    }
    public int getNumberFromText(String str){
    String temp=str.substring(1);
    int result =Integer.parseInt(temp);
    
    return result;
    }
    
    public String covertDateOfHTMLToSQL(String date){
        LocalDate startDate = LocalDate.parse(date);
         Date sqlStartDate = Date.valueOf(startDate);
     return sqlStartDate.toString();
    }
    public static void main(String[] args) {
        String str="p11";
        Util u=new Util();
        System.out.println(u.getNumberFromText(str));
        System.out.println(u.covertDateOfHTMLToSQL("16/01/2025"));
    }
}
