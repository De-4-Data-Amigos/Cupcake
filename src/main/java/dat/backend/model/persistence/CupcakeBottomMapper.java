package dat.backend.model.persistence;

import dat.backend.model.entities.CupcakeBottom;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CupcakeBottomMapper {
    static List<CupcakeBottom> getAllBottoms(ConnectionPool connectionPool) throws DatabaseException {

        String sql = "select * from cupcake_bottom;";

        List<CupcakeBottom> cupcakeBottomList =     new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int cupcakeBottomId = rs.getInt("cupcake_bottom_id");
                    int price = rs.getInt("price");
                    String flavor = rs.getString("flavor");

                    CupcakeBottom cupcakeBottom = new CupcakeBottom(cupcakeBottomId,price,flavor);
                    cupcakeBottomList.add(cupcakeBottom);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e, "Fejl i tilgangen til databasen");
        }
        return cupcakeBottomList;
    }
}

