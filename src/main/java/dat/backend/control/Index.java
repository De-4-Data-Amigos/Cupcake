package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.CupcakeTop;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeTopFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "index", value = "/index")
public class Index extends HttpServlet {

    private ConnectionPool connectionPool;

    List<CupcakeTop> allTops = new ArrayList<>();

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            allTops = CupcakeTopFacade.getAllTops(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("cupcaketops", allTops);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


}
}
