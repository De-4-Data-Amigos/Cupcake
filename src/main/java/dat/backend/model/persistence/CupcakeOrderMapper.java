package dat.backend.model.persistence;

import dat.backend.model.entities.CupcakeBottom;
import dat.backend.model.entities.CupcakeOrder;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CupcakeOrderMapper {

    static List<CupcakeOrder> getAllCupcakeOrders(ConnectionPool connectionPool) throws DatabaseException {

        String sql = "select * from cupcake_order;";

        List<CupcakeOrder> cupcakeOrderList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int cupcakeorderId = rs.getInt("cupcake_order_id");
                    int orderId = rs.getInt("order_id");
                    int price = rs.getInt("price");
                    int cupcakeTopId = rs.getInt("cupcake_top_id");
                    int cupcakeBottomId = rs.getInt("cupcake_bottom_id");



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
