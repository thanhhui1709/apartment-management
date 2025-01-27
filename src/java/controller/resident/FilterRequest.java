/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.resident;

import dao.RequestDAO;
import dao.RequestTypeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Account;
import model.Request;
import model.RequestType;
import util.Util;

/**
 *
 * @author NCPC
 */
@WebServlet(name = "FilterRequest", urlPatterns = {"/filterequest"})
public class FilterRequest extends HttpServlet {

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
            out.println("<title>Servlet FilterRequest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterRequest at " + request.getContextPath() + "</h1>");
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
        Account acc = (Account) session.getAttribute("account");
        RequestDAO rd = new RequestDAO();
        RequestTypeDAO rtd = new RequestTypeDAO();
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String typeRequest = request.getParameter("typeRequest");
        Util u = new Util();

        List<RequestType> listTypeRequest = rtd.getAll();

        List<Request> list = new ArrayList<>();

        if (from != null && !from.isEmpty() && to != null && !to.isEmpty()) {
            Date fromDate = u.convertStringToDate(from);
            Date toDate = u.convertStringToDate(to);
            int compareDate = fromDate.compareTo(toDate);

            if (compareDate >= 0) {
                list = rd.getByResidentIDAndDate(acc.getpId(), to, from, typeRequest);
            } else {
                list = rd.getByResidentIDAndDate(acc.getpId(), from, to, typeRequest);
            }
        } else if (typeRequest != null && !typeRequest.isEmpty()) {
            list = rd.getByResidentIDAndDate(acc.getpId(), null, null, typeRequest);
            Iterator<RequestType> iterator = listTypeRequest.iterator();
            while (iterator.hasNext()) {
                RequestType type = iterator.next();
                if (type.getId().equals(typeRequest)) {
                    session.setAttribute("selectedType", type);
                    iterator.remove(); // Safely remove the element
                }
            }
        } else {
            list = rd.getByResidentIDAndDate(acc.getpId(), null, null, null);
            session.removeAttribute("selectedType");
        }

        session.setAttribute("from", from);
        session.setAttribute("to", to);
        request.setAttribute("listRequest", list);
        request.setAttribute("listType", listTypeRequest);
        request.getRequestDispatcher("view_request_history.jsp").forward(request, response);
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
