/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import dao.RequestDAO;
import dao.RoleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Request;
import model.Role;

/**
 *
 * @author PC
 */
@WebServlet(name = "ViewAllRequest", urlPatterns = {"/view-all-request"})
public class ViewAllRequest extends HttpServlet {

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
            out.println("<title>Servlet ViewAllRequest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewAllRequest at " + request.getContextPath() + "</h1>");
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
        RequestDAO rd = new RequestDAO();
        List<Request> list = null;
        RoleDAO dao = new RoleDAO();
        List<Role> ls = new ArrayList<>();
        ls = dao.getAll();
        request.setAttribute("rolelist", ls);
        String filterRoles_raw = request.getParameter("filterRoles");
        String filterStatus_raw = request.getParameter("filterStatus");
        Account ac = (Account) session.getAttribute("account");
        if (ac.getRoleId() == 2) {
            list = rd.getAll();
        } else if (ac.getRoleId() > 2) {
            list = rd.getRequestByRoles(ac.getRoleId());
        }
        session.setAttribute("requestes", list);
        if (ac.getRoleId() == 2) {
            if (null != filterRoles_raw && !filterRoles_raw.isBlank()) {
                int filterRoles = Integer.parseInt(filterRoles_raw);
                list = rd.getByRoles(list, filterRoles);
                if (list.size() == 0) {
                    request.getRequestDispatcher("viewallrequest.jsp").forward(request, response);
                    return;
                }
                session.setAttribute("requestes", list);
            }
        }
        if (null != filterStatus_raw && !filterStatus_raw.isBlank()) {         
            list = rd.getByStatus(list, filterStatus_raw);
            if (list.size() == 0) {
                request.getRequestDispatcher("viewallrequest.jsp").forward(request, response);
                return;
            }
            session.setAttribute("requestes", list);
        }
        String page = request.getParameter("page");
        if (null == page) {
            page = "1";
        }
        int numberPerPage = 4;
        int totalPage;
        if (list.size() % numberPerPage == 0) {
            totalPage = list.size() / numberPerPage;
        } else {
            totalPage = list.size() / numberPerPage + 1;
        }
        list = rd.getPageByNumber(list, Integer.parseInt(page), numberPerPage);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("filterRoles", filterRoles_raw);
        request.setAttribute("filterStatus", filterStatus_raw);
        request.setAttribute("currentPage", Integer.parseInt(page));
        request.setAttribute("requestes", list);
        request.getRequestDispatcher("viewallrequest.jsp").forward(request, response);
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
