/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.resident;

import dao.ResidentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Resident;

/**
 *
 * @author pc
 */
@WebServlet(name = "EditprofileREServlet", urlPatterns = {"/editprofileREServlet"})
public class EditprofileREServlet extends HttpServlet {

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
            out.println("<title>Servlet EditprofileREServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditprofileREServlet at " + request.getContextPath() + "</h1>");
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

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login.jsp");
            return;
        }         

        String eemail = request.getParameter("editProfileEmail");
        String ephone = request.getParameter("editProfilePhone");
        String eaddress = request.getParameter("editProfileAddress");

        if (eemail == null || !eemail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
        request.setAttribute("status", "false");
        request.setAttribute("msg", "Invalid email format.");
        request.getRequestDispatcher("editprofileRE.jsp").forward(request, response);
        return;
    }

    if (ephone == null || !ephone.matches("^0[0-9]{9}$")) {
        request.setAttribute("status", "false");
        request.setAttribute("msg", "Please enter a valid phone number: 10 digits starting with 0.");
        request.getRequestDispatcher("editprofileRE.jsp").forward(request, response);
        return;
    }

    if (eaddress == null || eaddress.trim().isEmpty()) {
        request.setAttribute("status", "false");
        request.setAttribute("msg", "Address cannot be empty.");
        request.getRequestDispatcher("editprofileRE.jsp").forward(request, response);
        return;
    }

        Resident resident= new Resident(account.getpId(),eemail,ephone,eaddress);
        ResidentDAO re=new ResidentDAO();
        re.EditProfileRe(resident);
        resident=re.getById(account.getpId());
        
        session.setAttribute("person", resident);
        request.setAttribute("msg", "Update successfully");
        request.getRequestDispatcher("editprofileRE.jsp").forward(request, response);

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
