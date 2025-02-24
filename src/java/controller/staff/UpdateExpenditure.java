/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import dao.CompanyDAO;
import dao.ExpenditureDAO;
import dao.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Company;
import model.Expenditure;
import model.Staff;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "UpdateExpenditure", urlPatterns = {"/update-expenditure"})
public class UpdateExpenditure extends HttpServlet {

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
            out.println("<title>Servlet UpdateExpenditure</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateExpenditure at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        ExpenditureDAO ed = new ExpenditureDAO();
        StaffDAO sd = new StaffDAO();
        CompanyDAO cd = new CompanyDAO();

        List<Company> companies = cd.getAll();
        List<Staff> staffs = sd.getAll();
        Expenditure e = ed.getById(id);
        request.setAttribute("staffs", staffs);
        request.setAttribute("companies", companies);
        request.setAttribute("e", e);
        request.getRequestDispatcher("updateExpenditure.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        String amount_raw = request.getParameter("amount");
        String price_raw = request.getParameter("price");
        String apDate = request.getParameter("approvedDate");
        String payDate = request.getParameter("paydate");
        String note = request.getParameter("note");
        String category = request.getParameter("category");
        String companyId = request.getParameter("company");
        String staffId = request.getParameter("staff");

        try {
            int amount = Integer.parseInt(amount_raw);
            float price = Float.parseFloat(price_raw); // Fix: Use float instead of int

            StaffDAO sd = new StaffDAO();
            CompanyDAO cd = new CompanyDAO();
            ExpenditureDAO ed = new ExpenditureDAO();

            Expenditure e = new Expenditure(id, amount, price, apDate, payDate, note, category, cd.getById(companyId), sd.getById(staffId));

            boolean isUpdated = ed.updateExpenditure(e);

            if (isUpdated) {
                request.setAttribute("message", "Expenditure updated successfully!");
                request.setAttribute("status", "true");
            } else {
                request.setAttribute("message", "Failed to update expenditure.");
                request.setAttribute("status", "false");
            }

            request.getRequestDispatcher("updateExpenditure.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("message", "Invalid number format for Amount or Price.");
            request.setAttribute("status", "false");
            request.getRequestDispatcher("updateExpenditure.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An unexpected error occurred.");
            request.setAttribute("status", "false");
            request.getRequestDispatcher("updateExpenditure.jsp").forward(request, response);
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
