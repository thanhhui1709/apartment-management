/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import dao.CompanyDAO;
import java.util.List;
import model.Company;

/**
 *
 * @author thanh
 */
public class CompanyValidation {
    private CompanyDAO cd  = new CompanyDAO();
    private List<Company> list = cd.getAll();
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
    public boolean isExistName(String name){
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
