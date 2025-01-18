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

    public int getNumberFromText(String str) {
        return Integer.parseInt(str.substring(1));
    }
    public static void main(String[] args) {
        Util u=new  Util();
        System.out.println(u.getNumberFromText("p11"));
    }
}
