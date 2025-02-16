/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.ApartmentDAO;
import dao.LivingApartmentDAO;
import dao.OwnerApartmentDAO;
import dao.ResidentDAO;
import dao.RoomTypeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.Apartment;
import model.LivingApartment;
import model.OwnerApartment;
import model.Resident;
import model.RoomType;

/**
 *
 * @author quang
 */
@WebServlet(name = "UpdateApartmentServlet", urlPatterns = {"/update-apartment"})
public class UpdateApartmentServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateApartmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateApartmentServlet at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        ApartmentDAO dao = new ApartmentDAO();
        LivingApartmentDAO daoLA = new LivingApartmentDAO();
        OwnerApartmentDAO daoAO = new OwnerApartmentDAO();
        RoomTypeDAO daoRT = new RoomTypeDAO();
        ResidentDAO daoR = new ResidentDAO();

        List<Resident> listResident = daoR.getAllResident();
        List<RoomType> listRoomType = daoRT.getAll();
        Apartment a = dao.getById(id);
        LivingApartment la = daoLA.getLivingResidentByApartmentID(id);
        OwnerApartment oa = daoAO.getOwnerByApartmentID(id);

        request.setAttribute("apartment", a);
        request.setAttribute("livingResident", la);
        request.setAttribute("ownerApartment", oa);
        request.setAttribute("roomTypes", listRoomType);
        request.setAttribute("listResident", listResident);

        request.getRequestDispatcher("updateapartment.jsp").forward(request, response);

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
        String aid = request.getParameter("aid");
        String livingId = request.getParameter("livingResidentId"); //mới
        String ownerId = request.getParameter("apartmentOwnerId");// mới
        String livingApartmentId = request.getParameter("livingApartmentID");
        String apartmentOwnerId = request.getParameter("ApartmentID");
        String roomTypeId = request.getParameter("roomtype");
        String infor = request.getParameter("infor");
        String status = request.getParameter("status");

        ApartmentDAO dao = new ApartmentDAO();
        LivingApartmentDAO daoLA = new LivingApartmentDAO();
        OwnerApartmentDAO daoAO = new OwnerApartmentDAO();
        RoomTypeDAO daoRT = new RoomTypeDAO();
        ResidentDAO daoR = new ResidentDAO();

        OwnerApartment oa = daoAO.getOwnerByApartmentID(aid);
        LivingApartment la = daoLA.getLivingResidentByApartmentID(aid);

        Resident livingResident = daoR.getById(livingId);
        Resident ownerResident = daoR.getById(ownerId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        String date = now.format(formatter);

        RoomType rt = daoRT.getRoomTypeById(roomTypeId);
        Apartment a = dao.getById(aid);
        a.setRoomtype(rt);
        a.setInfor(infor);
        a.setStatus(Integer.parseInt(status));
   

        if (infor.trim() == "" || infor.trim().isEmpty()) {
            request.setAttribute("status", "false");
            request.setAttribute("message", "Apartment information can not be null");
            request.getRequestDispatcher("updateapartment.jsp").forward(request, response);
            return;
        }
        if (!dao.updateApartment(a)) {
            request.setAttribute("status", "false");
            request.setAttribute("message", "False to update 0");
            request.getRequestDispatcher("updateapartment.jsp").forward(request, response);
            return;
        }

        if (oa == null) {
            oa = new OwnerApartment();
            oa.setRid(ownerResident);
            oa.setEndDate(date);
            oa.setStatus(0);
            if (oa == null || !daoAO.updateOwnerApartment(oa)) {
                request.setAttribute("status", "false");
                request.setAttribute("message", "Failed to update 1");
                request.getRequestDispatcher("updateapartment.jsp").forward(request, response);
                return;
            }
            oa.setStatus(1);
            oa.setEndDate(null);
            oa.setStartDate(date);
            if (oa == null || !daoAO.insertOwnerApartment(oa)) {
                request.setAttribute("status", "false");
                request.setAttribute("message", "Failed to update 2");
                request.getRequestDispatcher("updateapartment.jsp").forward(request, response);
                return;
            }
        } else if (!oa.getRid().getpId().equals(ownerResident.getpId())) {
            oa.setRid(ownerResident);
            oa.setEndDate(date);
            oa.setStatus(0);
            if (oa == null || !daoAO.updateOwnerApartment(oa)) {
                request.setAttribute("status", "false");
                request.setAttribute("message", "Failed to update 1");
                request.getRequestDispatcher("updateapartment.jsp").forward(request, response);
                return;
            }
            oa.setStatus(1);
            oa.setEndDate(null);
            oa.setStartDate(date);
            if (oa == null || !daoAO.insertOwnerApartment(oa)) {
                request.setAttribute("status", "false");
                request.setAttribute("message", "Failed to update 2");
                request.getRequestDispatcher("updateapartment.jsp").forward(request, response);
                return;
            }
        }

        if (la == null) {
            la = new LivingApartment();
            la.setRid(livingResident);
            la.setEndDate(date);
            la.setStatus(0);
            if (!daoLA.updateLivingApartment(la)) {
                request.setAttribute("status", "false");
                request.setAttribute("message", "Failed to update 3 ");
                request.getRequestDispatcher("updateapartment.jsp").forward(request, response);
                return;
            }
            la.setStatus(1);
            la.setEndDate(null);
            la.setStartDate(date);
            if (!daoLA.insertLivingApartment(la)) {
                request.setAttribute("status", "false");
                request.setAttribute("message", "Failed to update 4");
                request.getRequestDispatcher("updateapartment.jsp").forward(request, response);
                return;
            }
            la = null;
        } else if (la != null && !la.getRid().getpId().equals(livingResident.getpId())) {
            la.setRid(livingResident);
            la.setEndDate(date);
            la.setStatus(0);
            if (!daoLA.updateLivingApartment(la)) {
                request.setAttribute("status", "false");
                request.setAttribute("message", "Failed to update 5 ");
                request.getRequestDispatcher("updateapartment.jsp").forward(request, response);
                return;
            }
            la.setStatus(1);
            la.setEndDate(null);
            la.setStartDate(date);
            if (!daoLA.insertLivingApartment(la)) {
                request.setAttribute("status", "false");
                request.setAttribute("message", "Failed to update 6");
                request.getRequestDispatcher("updateapartment.jsp").forward(request, response);
                return;
            }
        }
        List<Resident> listResident = daoR.getAllResident();
        List<RoomType> listRoomType = daoRT.getAll();

        la = daoLA.getLivingResidentByApartmentID(aid);
        oa = daoAO.getOwnerByApartmentID(aid);
        request.setAttribute("apartment", a);
        request.setAttribute("livingResident", la);
        request.setAttribute("ownerApartment", oa);
        request.setAttribute("roomTypes", listRoomType);
        request.setAttribute("listResident", listResident);
        request.setAttribute("status", "true");
        request.setAttribute("message", "Update successfully");
        request.getRequestDispatcher("updateapartment.jsp").forward(request, response);

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
