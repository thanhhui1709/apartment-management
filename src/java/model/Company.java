/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thanh
 */
public class Company {
    private String id;
    private String name;
    private String description;
    private String sdt;
    private String email;
    private String address;

    public Company() {
    }

    public Company(String name, String description, String sdt, String email, String address) {
        this.name = name;
        this.description = description;
        this.sdt = sdt;
        this.email = email;
        this.address = address;
    }

    public Company(String id, String name, String description, String sdt, String email, String address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sdt = sdt;
        this.email = email;
        this.address = address;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
