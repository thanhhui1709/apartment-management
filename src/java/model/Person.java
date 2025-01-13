/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author thanh
 */
public class Person {
    /*CREATE TABLE Person (
  Id       varchar(10) NOT NULL, 
  Fullname nvarchar(255) NOT NULL, 
  Bod      date NOT NULL, 
  Email    varchar(255) unique NOT NULL, 
  Sđt      varchar(11) unique NOT NULL, 
  Address  nvarchar(255) NOT NULL, 
  CCCD     varchar(12) unique NOT NULL, 
  PRIMARY KEY (Id));*/
    private String id;
    private String fullName;
    private String bod;
    private String email;
    private String sđt;
    private String address;
    private String cccd;

    public Person(String id, String fullName, String bod, String email, String sđt, String address, String cccd) {
        this.id = id;
        this.fullName = fullName;
        this.bod = bod;
        this.email = email;
        this.sđt = sđt;
        this.address = address;
        this.cccd = cccd;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getSđt() {
        return sđt;
    }

    public void setSđt(String sđt) {
        this.sđt = sđt;
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
    
    
}
