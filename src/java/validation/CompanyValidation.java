/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import dao.CompanyDAO;
import java.util.ArrayList;
import java.util.List;
import model.Company;

/**
 *
 * @author thanh
 */
public class CompanyValidation {
    private CompanyDAO cd  = new CompanyDAO();
    private List<Company> list;

    public CompanyValidation() {
    }
     public CompanyValidation(Company company) {
         list= cd.getAll();
         List<Company> newList =  new ArrayList<>();
         for (int i = 0; i < list.size(); i++) {
             if(list.get(i).getId().equals(company.getId())) continue;
             newList.add(list.get(i));
         }
         list = newList;
    }
    public boolean isValidCompany(Company company){
        return !(isExistContactEmail(company.getContactemail())
                || this.isExistContactPhone(company.getContactPhone())
                || this.isExistEmail(company.getEmail())
                || this.isExistFax(company.getFax())
                || this.isExistName(company.getName())
                || this.isExistPhone(company.getPhone())
                || this.isExistTaxCode(company.getTaxCode())
                || this.isExistWebsite(company.getWebsite())
                || this.isExistBank(company.getBank())
                || this.isExistDescription(company.getdescription())
                || this.isExistAddress(company.getAddress())
                );
    }
    public String findErrorMsgCompany(Company company){
        if(this.isExistAddress(company.getAddress())) return "Address is existed";
        if(this.isExistBank(company.getBank())) return "Bank is existed";
        if(this.isExistContactEmail(company.getContactemail())) return "Contact Email is existed";
        if(this.isExistContactPhone(company.getContactPhone())) return "Contact Phone is existed";
        if(this.isExistDescription(company.getdescription())) return "Description is existed";
        if(this.isExistEmail(company.getEmail())) return "Email is existed";
        if(this.isExistFax(company.getFax())) return "Fax is existed";
        if(this.isExistName(company.getName())) return "Name is existed";
        if(this.isExistPhone(company.getPhone())) return "Phone is existed";
        if(this.isExistTaxCode(company.getTaxCode())) return "Tax code is existed";
        if(this.isExistWebsite(company.getWebsite())) return "Website is existed";
        return null;
    }
    public boolean isExistEmail(String email){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getEmail().equalsIgnoreCase(email)) return true;
        }
        return false;
    }
    public boolean isExistPhone(String phone){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPhone().equalsIgnoreCase(phone)) return true;
        }
        return false;
    }
    public  boolean isExistName(String name){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }
    public boolean isExistFax(String fax){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getFax().equalsIgnoreCase(fax)) return true;
        }
        return false;
    }
    public boolean isExistContactPhone(String contactphone){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getContactPhone().equalsIgnoreCase(contactphone)) return true;
        }
        return false;
    }
    public boolean isExistContactEmail(String email){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getContactemail().equalsIgnoreCase(email)) return true;
        }
        return false;
    }
    public boolean isExistTaxCode(String taxCode){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getTaxCode().equalsIgnoreCase(taxCode)) return true;
        }
        return false;
    }
    public boolean isExistWebsite(String website){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getWebsite().equalsIgnoreCase(website)) return true;
        }
        return false;
    }
    public boolean isExistBank(String bank){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getBank().equalsIgnoreCase(bank)) return true;
        }
        return false;
    }
    public boolean isExistDescription(String description){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getdescription().equalsIgnoreCase(description)) return true;
        }
        return false;
    }
    public boolean isExistAddress(String address){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getAddress().equalsIgnoreCase(address)) return true;
        }
        return false;
    }
    
}
