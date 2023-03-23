package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "shoppingcard", value = "/shoppingcard")
public class shoppingcard extends HttpServlet {

        private ConnectionPool connectionPool;

        @Override
        public void init() throws ServletException {
            this.connectionPool = ApplicationStart.getConnectionPool();
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            if(user == null){
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
    }
}
