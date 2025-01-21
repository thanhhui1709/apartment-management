/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.ResidentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Resident;

/**
 *
 * @author quang
 */
@WebServlet(name = "FilterResidentServlet", urlPatterns = {"/filter-resident"})
public class FilterResidentServlet extends HttpServlet {

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
            out.println("<title>Servlet FilterResidentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterResidentServlet at " + request.getContextPath() + "</h1>");
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
        String name = request.getParameter("searchName");
        String status = request.getParameter("filterStatus");
        ResidentDAO daoR = new ResidentDAO();
        String numPage = request.getParameter("numPage");
        int index = 0;
        if (numPage == null) {
            index = 1;

        } else {
            index = Integer.parseInt(numPage);
        }
        int itemPerPage = 10;
        int numOfPage = 0;
        List<Resident> listResident = daoR.filterListResident(name, status);
        if (listResident.size() % 10 == 0) {
            numOfPage = listResident.size() / 10;
        } else {
            numOfPage = (listResident.size() / 10) + 1;
        }

        int start = (index - 1) * 10;
        int end = index * 10 <= listResident.size() ? index * 10 : listResident.size();
        List<Resident> listPagingResident = daoR.pagingResident2(listResident, start, end);

        request.setAttribute("listResident", listPagingResident);
        request.setAttribute("numOfPage", numOfPage);
        request.setAttribute("index", index);
        request.setAttribute("isFilter", "true");
        request.getRequestDispatcher("viewallresident.jsp").forward(request, response);
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
        processRequest(request, response);
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
