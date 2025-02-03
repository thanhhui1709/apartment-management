/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import dao.CompanyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Company;
import validation.CompanyValidation;

/**
 *
 * @author thanh
 */
@WebServlet(name = "UpdateCompanyServlet", urlPatterns = {"/update-company"})
public class UpdateCompanyServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateCompanyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCompanyServlet at " + request.getContextPath() + "</h1>");
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
        CompanyDAO cd = new CompanyDAO();
        String id = request.getParameter("id");
        Company company = cd.getById(id);
        request.setAttribute("company", company);
        request.setAttribute("pageName", "Update");
        request.setAttribute("url", "update-company");
        request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
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
        String name = request.getParameter("name").trim();
        String phone = request.getParameter("phone").trim();
        String contactphone = request.getParameter("contactPhone".trim());
        String fax = request.getParameter("fax").trim();
        String email = request.getParameter("email");
        String contactEmail = request.getParameter("contactemail").trim();
        String website = request.getParameter("website").trim();
        String taxCode = request.getParameter("taxCode").trim();
        String bank = request.getParameter("bank").trim();
        String address = request.getParameter("address").trim();
        String description = request.getParameter("description").trim();
        String id = request.getParameter("id").trim();
        Company company = new Company(id, name, phone, contactphone, fax, email, contactEmail, website, taxCode, bank, description, address);
        CompanyDAO cd = new CompanyDAO();
        CompanyValidation cv = new CompanyValidation(company);
        if (!cv.isValidCompany(company)) {
            request.setAttribute("error", cv.findErrorMsgCompany(company));
            request.setAttribute("company", cd.getById(id));
            request.setAttribute("pageName", "Update");
            request.setAttribute("url", "update-company");
            request.getRequestDispatcher("addnewcompany.jsp").forward(request, response);
            return;
        }
        cd.updateCompany(company);
        request.setAttribute("message", "Success");
        request.setAttribute("company", cd.getById(id));
        request.setAttribute("pageName", "Update");
        request.setAttribute("url", "update-company");
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
