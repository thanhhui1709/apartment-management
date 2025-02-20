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
import java.util.List;
import model.Account;
import model.Request;
import model.RequestType;

@WebServlet(name = "ViewRequestHistory", urlPatterns = {"/viewrequest_history"})
public class ViewRequestHistory extends HttpServlet {

    private static final int PAGE_SIZE = 8; // Number of rows per page

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("account");

        // Get the current page number from the request, default to 1 if not provided
        int page = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            page = Integer.parseInt(pageParam);
        }

        RequestDAO rd = new RequestDAO();
        RequestTypeDAO rtd = new RequestTypeDAO();

        // Fetch all requests for the resident
        List<Request> allRequests = rd.getByResidentID(acc.getpId());

        // Calculate pagination details
        int totalRequests = allRequests.size();
        int totalPages = (int) Math.ceil((double) totalRequests / PAGE_SIZE);

        // Calculate start and end indices for the current page
        int start = (page - 1) * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, totalRequests);

        // Get the paginated sublist
        List<Request> paginatedRequests = allRequests.subList(start, end);

        // Fetch all request types
        List<RequestType> listTypeRequest = rtd.getAll();

        // Set attributes for the JSP
        request.setAttribute("listType", listTypeRequest);
        request.setAttribute("rid", acc.getpId());
        request.setAttribute("listRequest", paginatedRequests);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        // Forward to the JSP
        request.getRequestDispatcher("view_request_history.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests if needed
    }

    @Override
    public String getServletInfo() {
        return "Servlet for viewing request history with pagination";
    }
}
