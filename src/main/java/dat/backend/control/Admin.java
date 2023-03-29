package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.OrderMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Admin", value = "/admin")
public class Admin extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            if (user.getRole().equalsIgnoreCase("admin")) {
                List<User> users = null;
                List<Order> orders = null;
                try {
                    users = AdminFacade.getAllUsers(connectionPool);
                    orders = OrderFacade.getAllOrders(connectionPool);
                } catch (DatabaseException e) {
                    request.getRequestDispatcher("error").forward(request, response);
                    e.printStackTrace();
                }
                request.setAttribute("userList", users);
                request.setAttribute("orderList",orders);
                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

            }
        }

        request.setAttribute("besked", "du er ikke en admin");
        request.getRequestDispatcher("index").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User _user = (User) request.getSession().getAttribute("user");
        if (!_user.getRole().equalsIgnoreCase("admin")) {

            request.setAttribute("besked", "du er ikke en admin");
            request.getRequestDispatcher("index").forward(request, response);

        }

        String username = request.getParameter("user");
        int money = Integer.parseInt(request.getParameter("money"));

        try {
            User user = AdminFacade.getUserFromUsername(username, connectionPool);

            AdminFacade.changeSaldo(user, money, connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }




        response.sendRedirect("admin");
    }

}

