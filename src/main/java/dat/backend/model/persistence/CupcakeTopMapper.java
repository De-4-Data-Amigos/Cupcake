package dat.backend.model.persistence;

import dat.backend.model.entities.CupcakeTop;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CupcakeTopMapper {
    static List<CupcakeTop> getAllTops(ConnectionPool connectionPool) throws DatabaseException {

        String sql = "select * from cupcake_top;";

        List<CupcakeTop> cupcakeTopList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int cupcakeTopId = rs.getInt("cupcake_top_id");
                    int price = rs.getInt("price");
                    String flavor = rs.getString("flavor");

                    CupcakeTop cupcakeTop = new CupcakeTop(cupcakeTopId,price,flavor);
                    cupcakeTopList.add(cupcakeTop);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e, "Fejl i tilgangen til databasen");
        }
        return cupcakeTopList;
    }
}
