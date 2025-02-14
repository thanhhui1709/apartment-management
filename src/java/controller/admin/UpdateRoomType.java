/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dao.RoomTypeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.RoomType;

/**
 *
 * @author PC
 */
@WebServlet(name="UpdateRoomType", urlPatterns={"/update-room-type"})
public class UpdateRoomType extends HttpServlet {
   
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
            out.println("<title>Servlet UpdateRoomType</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateRoomType at " + request.getContextPath () + "</h1>");
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
        String id = request.getParameter("id");
        RoomTypeDAO rdao = new RoomTypeDAO();
        RoomType roomtype =rdao.getRoomTypeById(id);
        request.setAttribute("roomtype", roomtype);
        request.getRequestDispatcher("updateroomtype.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String maxperson = request.getParameter("max-person");
        String square = request.getParameter("square");
        String bedroom = request.getParameter("bedroom");
        String livingroom = request.getParameter("living-room");        
        String bathroom = request.getParameter("bath-room");
        String balcony = request.getParameter("balcony");
        if(null == maxperson  || !maxperson.matches("[0-9]+") || maxperson.isBlank()){
            request.setAttribute("maxpersonError", "Max person is only degit");
            doGet(request, response);
            return;
        }
        if(null == square  || !square.matches("\\d+(\\.\\d+)?") || square.isBlank()){
            request.setAttribute("squareError", "Square is need as positive number");
            doGet(request, response);
            return;
        }
        if(null == bedroom  || !bedroom.matches("[0-9]+") || bedroom.isBlank()){
            request.setAttribute("bedroomError", "Bed room number is only degit");
            doGet(request, response);
            return;
        }
        if(null == livingroom  || !livingroom.matches("[0-9]+") || livingroom.isBlank()){
            request.setAttribute("livingroomError", "Living room number is only degit");
            doGet(request, response);
            return;
        }
        if(null == bathroom   || !bathroom.matches("[0-9]+") || bathroom.isBlank()){
            request.setAttribute("bathroomError", "Bath room number is only degit");
            doGet(request, response);
            return;
        }
        if(null == balcony || !balcony.matches("[0-9]+") || balcony.isBlank()){
            request.setAttribute("balconyError", "Balcony number is only degit");
            doGet(request, response);
            return;
        }
        RoomTypeDAO rdao = new RoomTypeDAO();
        RoomType roomtype = new RoomType(id, name, Integer.parseInt(maxperson), Integer.parseInt(bedroom), Integer.parseInt(livingroom), Integer.parseInt(bathroom), Integer.parseInt(balcony), Float.parseFloat(square));
        if(rdao.updateRoomType(roomtype)){
            response.sendRedirect("view-roomtype");
        }
        else{
            request.setAttribute("status", false);
            request.setAttribute("message", "Can not change room type");
            doGet(request, response);
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
