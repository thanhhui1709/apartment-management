/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thanh
 */
public class Resident {
    /*CREATE TABLE Resident (
  pId    varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Person (Id), 
  Bank   varchar(255) unique NOT NULL, 
  Subemail    varchar(255) unique NOT NULL, 
  [Status] varchar(255) NOT NULL, 
  PRIMARY KEY (pId));*/
    private Person pId;
    private String bank;
    private String submail;
    private String status;

    public Resident(Person pId, String bank, String submail, String status) {
        this.pId = pId;
        this.bank = bank;
        this.submail = submail;
        this.status = status;
    }

    
    
    public Person getpId() {
        return pId;
    }

    public void setpId(Person pId) {
        this.pId = pId;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getSubmail() {
        return submail;
    }

    public void setSubmail(String submail) {
        this.submail = submail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
