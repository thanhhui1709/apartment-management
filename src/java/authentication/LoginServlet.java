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
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if a "remembered" username cookie exists and pre-fill the username field
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("rememberedUser".equals(cookie.getName())) {
                    request.setAttribute("rememberedUser", cookie.getValue());
                    break;
                }
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String rememberMe = request.getParameter("saveUser"); // "saveUser" checkbox value
        AccountDAO dao = new AccountDAO();
        Account ac = dao.getAccountByUsername(user);

        if (user.isEmpty() || pass.isEmpty()) {
            request.setAttribute("error", "Username or Password cannot be blank.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        if (ac == null || !pass.equals(ac.getPassword())) {
            request.setAttribute("error", "Username or Password is incorrect.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Successful login
        session.setAttribute("account", ac);

        // Handle "Remember Me" functionality
        if ("save".equals(rememberMe)) {
            // Create a cookie to store the username
            Cookie cookie = new Cookie("rememberedUser", user);
            cookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
            response.addCookie(cookie);
        } else {
            // Remove the cookie if "Remember Me" is unchecked
            Cookie cookie = new Cookie("rememberedUser", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        response.sendRedirect("index.html");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
