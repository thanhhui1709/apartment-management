/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quang
 */
public class Contract {
    private Staff staff;
    private Company company;
    private String endDate, startDate, paymentTems, signDate, title, description;
    int status;

    public Contract(Staff staff, Company company, String endDate, String startDate, String paymentTems, String signDate, String title, String description, int status) {
        this.staff = staff;
        this.company = company;
        this.endDate = endDate;
        this.startDate = startDate;
        this.paymentTems = paymentTems;
        this.signDate = signDate;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPaymentTems() {
        return paymentTems;
    }

    public void setPaymentTems(String paymentTems) {
        this.paymentTems = paymentTems;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
