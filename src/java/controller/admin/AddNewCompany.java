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
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String descrip = request.getParameter("desctiption");
        CompanyDAO cd = new CompanyDAO();
        List<Company> listCompany = cd.getAll();
        if (null == listCompany) 
        {
        listCompany = new ArrayList<>();
        }
        
        Company newC= new Company(name,descrip,phone,email,address);
        for (Company company : listCompany) {
            try {
                if (company.getName().equalsIgnoreCase(newC.getName())) {
                    request.setAttribute("error", "Name is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }
                if (company.getSdt().equals(newC.getSdt())) {
                    request.setAttribute("error", "Phone is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }
                if (company.getEmail().equals(newC.getEmail())) {
                    request.setAttribute("error", "Email is existed");
                    request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
                    return;
                }
            } catch (Exception ex) {
                Logger.getLogger(AddNewCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (cd.inserNewCompany(newC)) {
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
