/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.resident;

import dao.RequestDAO;
import dao.RequestTypeDAO;
import dao.RuleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Request;
import model.RequestType;
import model.Rule;
import org.apache.tomcat.util.net.SSLSupport;

/**
 *
 * @author pc
 */
@WebServlet(name="UpdateRequest", urlPatterns={"/update-request"})
public class UpdateRequest extends HttpServlet {
   
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
            out.println("<title>Servlet UpdateRequest</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateRequest at " + request.getContextPath () + "</h1>");
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
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        RequestDAO rd= new RequestDAO();
        Request r=rd.getById(id);
        RequestTypeDAO rtd= new RequestTypeDAO();
        List<RequestType> listrequesttype=rtd.getAll();
        session.setAttribute("listrt", listrequesttype);
        session.setAttribute("request", r);
        request.getRequestDispatcher("editrequest.jsp").forward(request, response);
        
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
    String id = request.getParameter("reqID");
    String detail = request.getParameter("detail").trim();
    String typeRequestId = request.getParameter("typeRequest");
    
    RequestDAO rqd = new RequestDAO();
    RequestTypeDAO rqtd = new RequestTypeDAO();
    HttpSession session = request.getSession();
    
    try {
        if(detail.isEmpty()){
            session.setAttribute("status", "false");
            session.setAttribute("message", "Detail is not empty");
            response.sendRedirect("editrequest.jsp?id=" + id);
            return;
        }
        
        Request req = new Request();
        req.setId(id);
        req.setDetail(detail);
        req.setRequestType(rqtd.getById(typeRequestId));
        
        if (rqd.Editrequest(req)) {
            session.setAttribute("status", "true");
            session.setAttribute("message", "Request updated successfully!");
        } else {
            session.setAttribute("status", "false");
            session.setAttribute("message", "Update failed!");
        }
        
        response.sendRedirect("viewrequest_history");
        
    } catch (Exception e) {
        e.printStackTrace();
        session.setAttribute("status", "false");
        session.setAttribute("message", "An error occurred!");
        response.sendRedirect("editrequest.jsp?id=" + id);
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
