package controller.admin;

import dao.ApartmentDAO;
import dao.FloorDAO;
import dao.RoomTypeDAO;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Apartment;
import model.Floor;
import model.RoomType;

@WebServlet(name = "AddNewApartment", urlPatterns = {"/add-new-apartment"})
public class AddNewApartment extends HttpServlet {

    private static final Pattern APT_NUM_PATTERN = Pattern.compile("^[A-Z][0-9]{3}$");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoomTypeDAO rtd = new RoomTypeDAO();
        List<RoomType> listRoomType = rtd.getAll();
        request.setAttribute("listRoomType", listRoomType);
        request.getRequestDispatcher("addnewapartment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String aptNumber = request.getParameter("aptNum");
        String aptType_raw = request.getParameter("aptType");
        String aptFloor_raw = request.getParameter("aptFloor");
        String aptMember_raw = request.getParameter("aptMember");
        String aptInfor = request.getParameter("aptInfor");

        ApartmentDAO aptDAO = new ApartmentDAO();
        RoomTypeDAO rtf = new RoomTypeDAO();
        FloorDAO fd = new FloorDAO();

        try {
          

            int aptFloor = Integer.parseInt(aptFloor_raw);
            int aptMember = Integer.parseInt(aptMember_raw);

            Floor floor = fd.getByNumber(aptFloor);
            RoomType roomType = rtf.getRoomTypeById(aptType_raw);

            Apartment newApartment = new Apartment(aptNumber, aptMember, floor, aptInfor, roomType, 1);
            aptDAO.insertNewApartment(newApartment);
            response.sendRedirect("view-apartment-admin");

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input! Please enter valid numbers for Floor and Member Quantity.");
            request.getRequestDispatcher("addnewapartment.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred while adding the apartment. Please try again.");
            request.getRequestDispatcher("addnewapartment.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Handles adding a new apartment with validation.";
    }
}
