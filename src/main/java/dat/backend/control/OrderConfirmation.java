package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.CupcakeOrder;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeOrderFacade;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderConfirmation", value = "/orderconfirmation")
public class OrderConfirmation extends HttpServlet {

    private ConnectionPool connectionPool;
    /* private Order currentOrder; */

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
      /*  currentOrder = new Order(); */

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order order = (Order)session.getAttribute("current_order");
        if(order.getOrderAmount() == 0){
            request.getRequestDispatcher("index.jsp").forward(request,response);
            return;
        }
        User user = (User)session.getAttribute("user");

        List<CupcakeOrder> cupcakes = order.getCupcakes();

        int orderID;
        try {
            orderID = OrderFacade.addOrder(order, connectionPool);
            for (CupcakeOrder c: cupcakes) {
                CupcakeOrderFacade.addCupcakeOrderToOrder(orderID, c.getPrice(), c.getCupcakeTopId(), c.getCupcakeBottomId(), connectionPool);
            }
            if(user != null){
                if(user.getSaldo()-order.getTotalPrice() >= 0) {
                    AdminFacade.changeSaldo(user, -order.getTotalPrice(), connectionPool);
                    user.setSaldo(user.getSaldo()-order.getTotalPrice());
                }
            }

        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        order = new Order();
        session.setAttribute("current_order", order);

        request.getRequestDispatcher("orderconfirmation.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("orderconfirmation.jsp").forward(request,response);
    }
}
