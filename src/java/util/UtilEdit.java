/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author pc
 */
public class UtilEdit {
    public  String getTableNameByRoleIdEdit(int role){
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
        return "editprofile-"+destination;
    }
}
