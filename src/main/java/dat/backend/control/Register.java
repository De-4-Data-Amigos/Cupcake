package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // invalidating user object in session scope
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirmpassword");

        if(!password.equals(confirmpassword)) {
            request.setAttribute("message","Passwords did not match.");
            request.getSession().setAttribute("email", email);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

        try
        {

            User user = UserFacade.createUser(username, password, "user", 0, email, connectionPool);

            session = request.getSession();
            session.setAttribute("user", user); // adding user object to session scope
            session.setAttribute("email",email);
            Order order = (Order) session.getAttribute("current_order");
            order.setUser(user);
            Index.setOrder(order, session);

            // request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
            response.sendRedirect("index.jsp");
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

