/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin1711
 */
public class Staff {

    private String id;
    private String name;
    private String bod; // Date of birth as String
    private String email;
    private String phone;
    private String address;
    private String cccd; // Citizen ID
    private int salary;
    private String education;
    private String bank;
    private String username;
    private String password;
    private Role role; // Use Role object

    public Staff(String id, String name, String bod, String email, String phone, String address, String cccd, int salary, String education, String bank, String username, String password, Role role) {
        this.id = id;
        this.name = name;
        this.bod = bod;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cccd = cccd;
        this.salary = salary;
        this.education = education;
        this.bank = bank;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Staff() {
    }

    public Staff(String name, String bod, String email, String phone, String address, String cccd, int salary, String education, String bank, String username, String password) {
        this.name = name;
        this.bod = bod;
        this.email= email;
        this.phone=phone;
        this.address=address;
        this.cccd=cccd;
        this.salary=salary;
        this.education=education;
        this.bank=bank;
        this.username=username;
        this.password=password;
        
        
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
