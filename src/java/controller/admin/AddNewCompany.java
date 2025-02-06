/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.CompanyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Company;

/**
 *
 * @author PC
 */
public class AddNewCompany extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddNewCompany</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNewCompany at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String contactPhone = request.getParameter("contactPhone");
        String fax = request.getParameter("fax");
        String email = request.getParameter("email");
        String contactEmail = request.getParameter("contactemail");
        String website = request.getParameter("website");
        String taxCode = request.getParameter("taxCode");
        String bank = request.getParameter("bank");
        String address = request.getParameter("address");
        String description = request.getParameter("description");

        boolean hasError = false;

        // Validate tax code (must be exactly 10 digits)
        if (!taxCode.matches("\\d{10}")) {
            request.setAttribute("taxCodeError", "Tax code must have exactly 10 digits.");
            hasError = true;
        }
         // Validate fax  (must be exactly 10 digits)
        if (!fax.matches("\\d{10}")) {
            request.setAttribute("faxError", "Fax must have exactly 10 digits.");
            hasError = true;
        }

        // Validate phone and contact phone (must be exactly 11 digits)
        if (!phone.matches("\\d{11}")) {
            request.setAttribute("phoneError", "Phone number must have exactly 11 digits.");
            hasError = true;
        }
        if (!contactPhone.matches("\\d{11}")) {
            request.setAttribute("contactPhoneError", "Contact phone must have exactly 11 digits.");
            hasError = true;
        }

        // If there's an error, redirect back to the form
        if (hasError) {
            request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
            return;
        }

        CompanyDAO cd = new CompanyDAO();
        List<Company> listCompany = cd.getAll();
        if (listCompany == null) {
            listCompany = new ArrayList<>();
        }

        Company newC = new Company(name, phone, contactPhone, fax, email, contactEmail, website, taxCode, bank, description, address);

        for (Company company : listCompany) {
            try {
                if (company.getName().equalsIgnoreCase(newC.getName())) {
                    request.setAttribute("nameError", "Name already exists.");
                    hasError = true;
                }
                if (company.getPhone().equals(newC.getPhone())) {
                    request.setAttribute("phoneError", "Phone number already exists.");
                    hasError = true;
                }
                if (company.getContactPhone().equals(newC.getContactPhone())) {
                    request.setAttribute("contactPhoneError", "Contact phone already exists.");
                    hasError = true;
                }
                if (company.getTaxCode().equals(newC.getTaxCode())) {
                    request.setAttribute("taxCodeError", "Tax code already exists.");
                    hasError = true;
                }
                if (company.getWebsite().equals(newC.getWebsite())) {
                    request.setAttribute("websiteError", "Website already exists.");
                    hasError = true;
                }
                if (hasError) {
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }

            } catch (Exception ex) {
                Logger.getLogger(AddNewCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (cd.insertNewCompany(newC)) {
            request.setAttribute("status", "true");
            request.setAttribute("message", "New company added successfully!");
        } else {
            request.setAttribute("status", "false");
            request.setAttribute("message", "Failed to add new company!");
        }

        request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
