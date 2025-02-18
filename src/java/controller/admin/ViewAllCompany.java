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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Company;
import util.Util;

/**
 *
 * @author PC
 */
public class ViewAllCompany extends HttpServlet {

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
            out.println("<title>Servlet ViewAllCompany</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewAllCompany at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        CompanyDAO cd = new CompanyDAO();
        List<Company> list;
        Util u = new Util();
        if (null == session.getAttribute("companies")) {
            list = cd.getAll();
            session.setAttribute("companies", list);
        } else {
            list = (List<Company>) session.getAttribute("companies");
        }
        String searchName = request.getParameter("searchName");
        int totalPage = u.getTotalPage(list, 3);
        if (null != searchName) {
            searchName = u.stringNomalize(searchName);
            list = cd.searchCompaniesbyName(searchName);
            if (list.size() == 0) {
                request.setAttribute("totalPage", 1);
                request.getRequestDispatcher("viewallcompany.jsp").forward(request, response);
                return;
            }
            session.setAttribute("companies", list);
        }
        String page = request.getParameter("page");
        if (null == page) {
            page = "1";
        }
        
        list = u.getListPerPage(list, 3, page);        
        request.setAttribute("totalPage", totalPage);
        
        request.setAttribute("currentPage", Integer.parseInt(page));
        request.setAttribute("companies", list);
        request.getRequestDispatcher("viewallcompany.jsp").forward(request, response);
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
        processRequest(request, response);
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
