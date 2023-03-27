package dat.backend.control;

import dat.backend.model.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Admin", value = "/Admin")
public class Admin extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = (User) request.getSession().getAttribute("role");
            if (user.getRole().equalsIgnoreCase("admin")) {
                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

            }
            request.setAttribute("besked", "du er ikke en admin");
            request.getRequestDispatcher("index").forward(request, response);

        }

}