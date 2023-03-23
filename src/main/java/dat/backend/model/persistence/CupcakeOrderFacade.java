package dat.backend.model.persistence;

import dat.backend.model.entities.CupcakeOrder;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class CupcakeOrderFacade
{
    public static List<CupcakeOrder> getAllCupcakeOrders(ConnectionPool connectionPool) throws DatabaseException
    {
        return CupcakeOrderMapper.getAllCupcakeOrders(connectionPool);
    }
    public static CupcakeOrder getCupcakeOrderFromOrderId(int order_id, ConnectionPool connectionPool) throws DatabaseException
    {
        return CupcakeOrderMapper.getCupcakeOrderFromOrderId(order_id, connectionPool);
    }
}
