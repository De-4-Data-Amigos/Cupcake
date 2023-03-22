package dat.backend.model.persistence;

import dat.backend.model.entities.CupcakeOrder;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {


    static List<CupcakeOrder> getAllOrders(ConnectionPool connectionPool) throws DatabaseException {

        String sql = "select * from orders;";

        List<CupcakeOrder> cupcakeOrderList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    int totalPrice = rs.getInt("total_price");
                    Timestamp timestamp = rs.getTimestamp("order_creation_timestamp");
                    String username = rs.getString("username");
                    boolean isOrderActive = rs.getBoolean("is_order_active");
                    int orderAmount = rs.getInt("order_amount");



                    CupcakeOrder cupcakeOrder = new CupcakeOrder(cupcakeorderId, orderId, price, cupcakeTopId, cupcakeBottomId);
                    cupcakeOrderList.add(cupcakeOrder);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e, "Fejl i tilgangen til databasen");
        }
        return cupcakeOrderList;
    }
}
