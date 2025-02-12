/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import dao.NewDAO;
import dao.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.util.List;
import model.News;
import model.Staff;

/**
 *
 * @author quang
 */
@WebServlet(name = "UpdateNewServlet", urlPatterns = {"/update-news"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UpdateNewServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateNewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateNewServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        NewDAO ndao = new NewDAO();
        StaffDAO sdao = new StaffDAO();
        List<String> categories = ndao.getAllCategory();
        List<Staff> staffs = sdao.getAdminAndAdministrative();
        News news = ndao.getNewById(request.getParameter("id"));
        session.setAttribute("categories", categories);
        session.setAttribute("staffs", staffs);
        request.setAttribute("news", news);
        request.getRequestDispatcher("updatenews.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String source = request.getParameter("source");
        String date = request.getParameter("date");
        String category = request.getParameter("category");
        String auther = request.getParameter("auther");

        Part fileImage = request.getPart("file");
        String image = "";
        if (fileImage != null && fileImage.getSize() > 0) {
            image = "images/news/" + fileImage.getSubmittedFileName();
        }

        NewDAO ndao = new NewDAO();
        StaffDAO sdao = new StaffDAO();
        News anew = new News(id, title, content, source, category, image, sdao.getById(auther), date);
        if (title.trim().isEmpty() || title.trim() == "") {
            request.setAttribute("status", "false");
            request.setAttribute("message", "Title can not be empty.");
            News news = ndao.getNewById(request.getParameter("id"));
            request.setAttribute("news", news);
            request.getRequestDispatcher("updatenews.jsp").forward(request, response);
            return;
        }

        if (content.trim().isEmpty() || content.trim() == "") {
            request.setAttribute("status", "false");
            request.setAttribute("message", "Content can not be empty.");
            News news = ndao.getNewById(request.getParameter("id"));
            request.setAttribute("news", news);
            request.getRequestDispatcher("updatenews.jsp").forward(request, response);
            return;
        } else {
            if (ndao.updateNews(anew)) {
                request.setAttribute("status", "true");
                request.setAttribute("message", "News updated successfully!");
            } else {
                request.setAttribute("status", "false");
                request.setAttribute("message", "Failed to update news.");
            }
        }
        News news = ndao.getNewById(request.getParameter("id"));
        request.setAttribute("news", news);
        request.getRequestDispatcher("updatenews.jsp").forward(request, response);
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
