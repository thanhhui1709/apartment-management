/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import dao.FloorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author thanh
 */
@WebServlet(name = "ViewFloorServlet", urlPatterns = {"/view-floor-staff"})
public class ViewFloorServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewFloorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewFloorServlet at " + request.getContextPath() + "</h1>");
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
        FloorDAO fd = new FloorDAO();
        request.setAttribute("floors", fd.getAll());
        request.setAttribute("types", fd.getAllUsageType());
        request.setAttribute("nofloor", fd.getAll().size());
        request.getRequestDispatcher("floorinformation.jsp").forward(request, response);
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
        String type = request.getParameter("type");
        FloorDAO fd = new FloorDAO();
        String numFloor = request.getParameter("numFloor");
        if (type != null) {
            if (type.equals("all")) {
                request.setAttribute("floors", fd.getAll());
                request.setAttribute("types", fd.getAllUsageType());
                request.setAttribute("nofloor", fd.getAll().size());
                request.getRequestDispatcher("floorinformation.jsp").forward(request, response);
                return;
            }
            else{
                 request.setAttribute("floors", fd.getByUsageType(type));
                request.setAttribute("types", fd.getAllUsageType());
                request.setAttribute("nofloor", fd.getAll().size());
                request.getRequestDispatcher("floorinformation.jsp").forward(request, response);
                return;
            }
        }
        System.out.println(numFloor);
        if (numFloor != null) {
            if (numFloor.equals("all")) {
                request.setAttribute("floors", fd.getAll());
                request.setAttribute("types", fd.getAllUsageType());
                request.setAttribute("nofloor", fd.getAll().size());
                request.getRequestDispatcher("floorinformation.jsp").forward(request, response);
                return;
            }
            else{
                 request.setAttribute("floors", fd.getByNumberFloor(Integer.parseInt(numFloor)));
                request.setAttribute("types", fd.getAllUsageType());
                request.setAttribute("nofloor", fd.getAll().size());
                request.getRequestDispatcher("floorinformation.jsp").forward(request, response);
                return;
            }
        }
        doGet(request, response);
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
