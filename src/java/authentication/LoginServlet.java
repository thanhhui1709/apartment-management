/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package authentication;

<<<<<<< Updated upstream
import dao.AccountDAO;
import dao.RoleDAO;
=======
import dao.EmployeeDAO;
>>>>>>> Stashed changes
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
<<<<<<< Updated upstream
import model.Role;
=======
>>>>>>> Stashed changes

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< Updated upstream
        HttpSession session = request.getSession();
        RoleDAO dao = new RoleDAO();
        List<Role> list = new ArrayList<>();
        list = dao.getAll();
        session.setAttribute("rolelist", list);
        request.getRequestDispatcher("login.jsp").forward(request, response);

=======
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("rememberedUser".equals(cookie.getName())) {
//                    request.setAttribute("rememberedUser", cookie.getValue());
//                    break;
//                }
//            }
//        }
//        request.getRequestDispatcher("login.jsp").forward(request, response);
>>>>>>> Stashed changes
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String checkrole = request.getParameter("role");
        int role;
        if (checkrole == null) {
            request.setAttribute("error", "Role is not allowed to be blank");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        } else {
            role = Integer.parseInt(checkrole);
        }
<<<<<<< Updated upstream
        AccountDAO dao = new AccountDAO();
=======
        EmployeeDAO dao = new EmployeeDAO();
>>>>>>> Stashed changes
        Account ac = dao.getAccountByUsernameandRole(user, role);
        if (user.isEmpty() || pass.isEmpty()) {
            request.setAttribute("error", "Username or Password is not allowed to be blank");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        if (ac == null) {
            request.setAttribute("error", "Username or Password is incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        if (user.equals(ac.getUsername()) && pass.equals(ac.getPassword())) {
            session.setAttribute("account", ac);
            String remember = request.getParameter("remember");
            if ("on".equals(remember)) {
                // Create and configure cookies for username and password
                Cookie cookieUser = new Cookie("rememberedUser", user);
                Cookie cookiePass = new Cookie("rememberedPass", pass);
                cookieUser.setMaxAge(60 * 60);
                cookiePass.setMaxAge(60 * 60);
                response.addCookie(cookieUser);
                response.addCookie(cookiePass);
<<<<<<< Updated upstream
            } else {
=======
            } 
            else {
>>>>>>> Stashed changes
                // Clear both cookies by setting max age to 0
                Cookie cookieUser = new Cookie("rememberedUser", user);
                Cookie cookiePass = new Cookie("rememberedPass", pass);
                cookieUser.setMaxAge(0);
                cookiePass.setMaxAge(0);
                response.addCookie(cookieUser);
                response.addCookie(cookiePass);
            }

<<<<<<< Updated upstream
            response.sendRedirect("index.jsp");
=======
            response.sendRedirect("index.html");
>>>>>>> Stashed changes
        } else {
            request.setAttribute("error", "Username or Password is incorrect");
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
