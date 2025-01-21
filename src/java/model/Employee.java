/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin1711
 */
public class Employee {

    private String id;
    private String name;
    private String bod; // Date of birth as String
    private String email;
    private String phone;
    private String address;
    private String cccd; // Citizen ID
    private ServiceProvider company; // Foreign key reference
    private String startDate; // Start date as String
    private String endDate; // End date as String
    private int status;
    private String username;
    private String password;
    private Role role; // Use Role object

    public Employee() {
    }

    public Employee(String id, String name, String bod, String email, String phone, String address, String cccd, ServiceProvider company, String startDate, String endDate, int status, String username, String password, Role role) {
        this.id = id;
        this.name = name;
        this.bod = bod;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cccd = cccd;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.username = username;
        this.password = password;
        this.role = role;
    }
//name, dob, email, phone, address, cccd, sp, startDate, username, password

    public Employee(String name, String bod, String email, String phone, String address, String cccd, ServiceProvider company, String startDate, String username, String password) {
        this.name = name;
        this.bod = bod;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cccd = cccd;
        this.company = company;
        this.startDate = startDate;
        this.username = username;
        this.password = password;
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

    public ServiceProvider getCompany() {
        return company;
    }

    public void setCompany(ServiceProvider company) {
        this.company = company;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
