/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.CompanyDAO;
import dao.RoleDAO;
import dao.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Company;
import model.Role;
import model.Staff;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "UpdateStaffInfor", urlPatterns = {"/updateStaffInfor"})
public class UpdateStaffInfor extends HttpServlet {

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
            out.println("<title>Servlet UpdateStaffInfor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStaffInfor at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        StaffDAO sd = new StaffDAO();
        Staff staff = sd.getById(id);
        request.setAttribute("staff", staff);
        request.getRequestDispatcher("updateStaffInfor.jsp").forward(request, response);
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

        String id = request.getParameter("staffID");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String cccd = request.getParameter("cccd");
        String education = request.getParameter("education");
        String bank = request.getParameter("bank");
        String salary_raw = request.getParameter("salary");
        String companyId = request.getParameter("company");
        String status_raw = request.getParameter("status");
        String role = request.getParameter("role");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        StaffDAO daoSt = new StaffDAO();
        CompanyDAO daoCp = new CompanyDAO();
        RoleDAO daoR = new RoleDAO();

        try {
            int status = Integer.parseInt(status_raw);
            int salary = Integer.parseInt(salary_raw);
            if (!name.isEmpty() && !dob.isEmpty() && !email.isEmpty() && !address.isEmpty() && !phone.isEmpty() && !cccd.isEmpty()
                    && !education.isEmpty() && !bank.isEmpty() && !salary_raw.isEmpty()
                    && !companyId.isEmpty() && !status_raw.isEmpty() && !role.isEmpty() && !startDate.isEmpty()) {

                Staff staff = new Staff(
                        id, name, dob, email, phone, address, cccd, salary,
                        education, bank, status, daoR.getById(role), daoCp.getById(companyId),
                        startDate, (endDate == null || endDate.isEmpty()) ? null : endDate
                );

                daoSt.updateStaffInfor(staff);
                HttpSession session = request.getSession();
                session.setAttribute("staffs", daoSt.getAll());
                response.sendRedirect("view-all-staff");

            } else {
                Staff staff = daoSt.getById(id);
                request.setAttribute("staff", staff);
                request.setAttribute("errorMess", "Input fields couldn't be empty");
                request.getRequestDispatcher("updateStaffInfor.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            Staff staff = daoSt.getById(id);
            request.setAttribute("staff", staff);
            request.setAttribute("status", "false");
            request.setAttribute("errorMess", "Invalid salary format.");
            request.getRequestDispatcher("updateStaffInfor.jsp").forward(request, response);
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
