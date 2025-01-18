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
}
