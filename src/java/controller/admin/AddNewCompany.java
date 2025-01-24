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
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<h1>Servlet AddNewCompany at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
        CompanyDAO cd = new CompanyDAO();
        List<Company> listCompany = cd.getAll();
        if (null == listCompany) {
            listCompany = new ArrayList<>();
        }

        Company newC = new Company(name, phone, contactPhone, fax, email, contactEmail, website, taxCode, bank, description, address);
        for (Company company : listCompany) {
            try {
                if (company.getName().equalsIgnoreCase(newC.getName())) {
                    request.setAttribute("error", "Name is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }
                if (company.getPhone().equals(newC.getPhone())) {
                    request.setAttribute("error", "Phone is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }
                if (company.getContactPhone().equals(newC.getContactPhone())) {
                    request.setAttribute("error", "Contact phone is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }
                if (company.getFax().equals(newC.getFax())) {
                    request.setAttribute("error", "Contact phone is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }

                if (company.getEmail().equals(newC.getEmail())) {
                    request.setAttribute("error", "Email is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }
                if (company.getContactemail().equals(newC.getContactemail())) {
                    request.setAttribute("error", "Contact email is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }
                if (company.getWebsite().equals(newC.getWebsite())) {
                    request.setAttribute("error", "Website is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }

                if (company.getTaxCode().equals(newC.getTaxCode())) {
                    request.setAttribute("error", "Tax code is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }

                if (company.getBank().equals(newC.getBank())) {

                    request.setAttribute("error", "Bank code is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }

            } catch (Exception ex) {
                Logger.getLogger(AddNewCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (cd.insertNewCompany(newC)) {
            request.setAttribute("status", "true");
            request.setAttribute("message", "Add new company successfully!");
            request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
        } else {
            request.setAttribute("status", "false");
            request.setAttribute("message", "Cannot add new company!");
            request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
        }
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
