/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.EmployeeDAO;
import dao.ServiceProviderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Formatter;
import java.util.List;
import model.Employee;
import model.ServiceProvider;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
@WebServlet(name = "AddNewEmployeeServlet", urlPatterns = {"/add-new-employee"})
public class AddNewEmployeeServlet extends HttpServlet {

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
            out.println("<title>Servlet AddNewEmployeeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNewEmployeeServlet at " + request.getContextPath() + "</h1>");
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
        ServiceProviderDAO daoSP = new ServiceProviderDAO();
        HttpSession session = request.getSession();
        List<ServiceProvider> list = daoSP.getAll();

        session.setAttribute("listServiceProvider", list);
        request.getRequestDispatcher("addnewemployee.jsp").forward(request, response);
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
        String cccd = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String startDate = request.getParameter("startDate");
        String company = request.getParameter("serviceProvider");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        EmployeeDAO daoE = new EmployeeDAO();
        List<Employee> listEmployee = daoE.getAll();
        Employee newE = new Employee(name, dob, email, phone, address, cccd, company, startDate, username, password);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ZoneId zone = ZoneId.systemDefault();
        for (Employee e : listEmployee) {
            try {
                if (e.getCccd().equals(newE.getCccd())) {
                    request.setAttribute("error", "CCCD is existed");
                    request.getRequestDispatcher("addnewemployee.jsp").forward(request, response);
                    return;
                }

                Date dateOfBirth = format.parse(dob);
                LocalDate birthDate = dateOfBirth.toInstant().atZone(zone).toLocalDate();
                LocalDate currentDate = LocalDate.now();

                int age = currentDate.getYear() - birthDate.getYear();
                if (currentDate.getDayOfYear() < birthDate.getDayOfYear()) {
                    age--; 
                }
                
                if (age <= 18) {
                    request.setAttribute("error", "The employee's age must be greater than 18.");
                    request.getRequestDispatcher("addnewemployee.jsp").forward(request, response);
                    return;
                }

                if (e.getPhone().equals(newE.getPhone())) {
                    request.setAttribute("error", "Phone is existed");
                    request.getRequestDispatcher("addnewemployee.jsp").forward(request, response);
                    return;
                }
                if (e.getEmail().equals(newE.getEmail())) {
                    request.setAttribute("error", "Email is existed");
                    request.getRequestDispatcher("addnewemployee.jsp").forward(request, response);
                    return;
                }

                if (e.getUsername().equals(newE.getUsername())) {
                    request.setAttribute("error", "Username is existed");
                    request.getRequestDispatcher("addnewemployee.jsp").forward(request, response);
                    return;
                }
            } catch (ParseException ex) {
                Logger.getLogger(AddNewEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (daoE.insertEmployee(newE)) {
            request.setAttribute("status", "true");
            request.setAttribute("message", "Add new employee successfully!");
            request.getRequestDispatcher("addnewemployee.jsp").forward(request, response);
        } else {
            request.setAttribute("status", "false");
            request.setAttribute("message", "Cannot add new employee!");
            request.getRequestDispatcher("addnewemployee.jsp").forward(request, response);
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
