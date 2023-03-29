package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.CupcakeBottom;
import dat.backend.model.entities.CupcakeOrder;
import dat.backend.model.entities.CupcakeTop;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeBottomFacade;
import dat.backend.model.persistence.CupcakeTopFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.zip.DataFormatException;

@WebServlet(name = "AddCupcakeOrder", value = "/AddCupcakeOrder")
public class AddCupcakeOrder extends HttpServlet
{
    private ConnectionPool connectionPool;


    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendRedirect("index");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int bottomID = -1;
        int topID = -1;
        try {
            bottomID = Integer.parseInt(request.getParameter("bottom"));
            topID = Integer.parseInt(request.getParameter("top"));
        }
        catch (NumberFormatException e ){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if(bottomID == -1 || topID == -1 ){
            response.sendRedirect("index");
        }
        CupcakeBottom cupcakeBottom = null;
        CupcakeTop cupcakeTop = null;
        try {
            cupcakeBottom = CupcakeBottomFacade.getButtomFromId(bottomID, connectionPool);
            cupcakeTop = CupcakeTopFacade.getTopFromId(topID, connectionPool);
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        int totalPrice = cupcakeTop.getPrice() + cupcakeBottom.getPrice();

        HttpSession session = request.getSession();
        Order order = (Order)session.getAttribute("current_order");
        CupcakeOrder cupcakeOrder = new CupcakeOrder(topID, bottomID, totalPrice);
        order.addCupcake(cupcakeOrder);
        response.sendRedirect("index");
    }
}