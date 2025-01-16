/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author thanh
 */
public class Util {
    public  String getTableNameByRoleId(int role){
        String destination = "";
        if(role==3) destination= "employee";
        else if(role==1) destination= "resident";
        else if(role==4) destination= "render";
        else destination="staff";
        return "view-profile-"+destination;
    }
}
