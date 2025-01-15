/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package authentication;


import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;


/**
 *
 * @author PC
 */
public class LoginServlet extends HttpServlet {

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
        //processRequest(request, response);
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
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String checkrole = request.getParameter("role");
        int role = 0;
        if(null == checkrole){
            request.setAttribute("error", "Role is not allow a blank");
            request.getRequestDispatcher("login.jsp").forward(request, response);            
        }else{
            role = Integer.parseInt(checkrole);
        }
        AccountDAO dao = new AccountDAO();
        Account ac = dao.getAccountByUsernameandRole(user,role);
        if (user.isEmpty() && pass.isEmpty()) {
            request.setAttribute("error", "Username or Password is not allow a blank");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        if (null == ac) {
            request.setAttribute("error", "Username or Password is incorect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (user.equals(ac.getUsername()) && pass.equals(ac.getPassword())) {
            // push role to session
            session.setAttribute("account", ac);
            response.sendRedirect("index.html");
        } else {
            request.setAttribute("error", "Username or Password is incorect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
