/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quang
 */
public class Rule {

    private String id;
    private String title, description, date, effectiveDate, status;
    private Staff staff;

    public Rule(String id, String title, String description, String date, String effectiveDate, String status, Staff staff) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.effectiveDate = effectiveDate;
        this.status = status;
        this.staff = staff;
    }

    public Rule(String title, String description, String date, String effectiveDate, String status, Staff staff) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.effectiveDate = effectiveDate;
        this.status = status;
        this.staff = staff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

}
