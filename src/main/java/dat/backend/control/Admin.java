package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
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
        if (user.getRole().equalsIgnoreCase("admin")) {
            List<User> users = null;
            try {
                users = AdminFacade.getAllUsers(connectionPool);
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
            request.setAttribute("userList", users);
            request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

        }
        request.setAttribute("besked", "du er ikke en admin");
        request.getRequestDispatcher("index").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        int money = Integer.parseInt(request.getParameter("money"));

        try {
            User user = AdminFacade.getUserFromUsername(connectionPool,username);

            AdminFacade.addMoney(connectionPool, user, money);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }


        response.sendRedirect("admin");
    }

}

