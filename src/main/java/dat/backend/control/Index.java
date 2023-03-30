package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.CupcakeBottom;
import dat.backend.model.entities.CupcakeTop;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "index", urlPatterns = {"/index"})
public class Index extends HttpServlet {

    private ConnectionPool connectionPool;
    private static Order currentOrder;


    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
        currentOrder = new Order();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CupcakeTop> allTops = new ArrayList<>();
        List<CupcakeBottom> allBottoms = new ArrayList<>();

        try {
            allTops = CupcakeTopFacade.getAllTops(connectionPool);
            allBottoms = CupcakeBottomFacade.getAllBottoms(connectionPool);
        } catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        HttpSession session = request.getSession();
        session.setAttribute("cupcaketops", allTops);
        session.setAttribute("cupcakebottoms", allBottoms);
        setOrder(currentOrder, session);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bottomParameter = request.getParameter("bottom");
        String topParameter = request.getParameter("top");
        if(bottomParameter == null && topParameter == null){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


        if(bottomParameter == null){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        int bottomId = Integer.parseInt(bottomParameter);
        CupcakeBottom bottom = null;
        try {
            bottom = CupcakeBottomFacade.getButtomFromId(bottomId, connectionPool);
        } catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.setAttribute("cupcake_bottom", bottom);

        if(topParameter == null){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        int topId = Integer.parseInt(topParameter);


    }

    public static void setOrder(Order order, HttpSession session){
        currentOrder = order;
        session.setAttribute("current_order", currentOrder);
    }

}
