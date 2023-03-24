package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;

public class OrderFacade {
    public static int addOrder(ConnectionPool connectionPool, Order order) throws SQLException, DatabaseException {
        return OrderMapper.addOrder(connectionPool, order);
    }
}
