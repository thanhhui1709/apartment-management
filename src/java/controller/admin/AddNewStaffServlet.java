/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dao.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.Staff;

/**
 *
 * @author pc
 */
@WebServlet(name="AddNewStaffServlet", urlPatterns={"/add-new-staff"})
public class AddNewStaffServlet extends HttpServlet {
   
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
            out.println("<title>Servlet AddNewStaffServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNewStaffServlet at " + request.getContextPath () + "</h1>");
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
        String cccd = request.getParameter("cccd");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String bod = request.getParameter("dob");
        String salary_raw = request.getParameter("salary");
        String education = request.getParameter("education");
        String bank = request.getParameter("bank");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int salary=Integer.parseInt(salary_raw);
        StaffDAO stDao = new StaffDAO();
        List<Staff> listStaff = stDao.getAll();
        if (listStaff == null) 
        {
        listStaff = new ArrayList<>();
        }
        
        Staff newS= new Staff(name, bod, email, phone, address, cccd, salary, education, bank, username, password);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ZoneId zone = ZoneId.systemDefault();
        for (Staff e : listStaff) {
            try {
                if (e.getCccd().equals(newS.getCccd())) {
                    request.setAttribute("error", "CCCD is existed");
                    request.getRequestDispatcher("addnewstaff.jsp").forward(request, response);
                    return;
                }

                Date dateOfBirth = format.parse(bod);
                LocalDate birthDate = dateOfBirth.toInstant().atZone(zone).toLocalDate();
                LocalDate currentDate = LocalDate.now();

                int age = currentDate.getYear() - birthDate.getYear();
                if (currentDate.getDayOfYear() < birthDate.getDayOfYear()) {
                    age--;
                }

                if (age <= 18) {
                    request.setAttribute("error", "The staff's age must be greater than 18.");
                    request.getRequestDispatcher("addnewstaff.jsp").forward(request, response);
                    return;
                }

                if (e.getPhone().equals(newS.getPhone())) {
                    request.setAttribute("error", "Phone is existed");
                    request.getRequestDispatcher("addnewstaff.jsp").forward(request, response);
                    return;
                }
                if (e.getEmail().equals(newS.getEmail())) {
                    request.setAttribute("error", "Email is existed");
                    request.getRequestDispatcher("addnewstaff.jsp").forward(request, response);
                    return;
                }

                if (e.getUsername().equals(newS.getUsername())) {
                    request.setAttribute("error", "Username is existed");
                    request.getRequestDispatcher("addnewstaff.jsp").forward(request, response);
                    return;
                }
            } catch (ParseException ex) {
                Logger.getLogger(AddNewStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (stDao.insertStaff(newS)) {
            request.setAttribute("status", "true");
            request.setAttribute("message", "Add new staff successfully!");
            request.getRequestDispatcher("addnewstaff.jsp").forward(request, response);
        } else {
            request.setAttribute("status", "false");
            request.setAttribute("message", "Cannot add new staff!");
            request.getRequestDispatcher("addnewstaff.jsp").forward(request, response);
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
