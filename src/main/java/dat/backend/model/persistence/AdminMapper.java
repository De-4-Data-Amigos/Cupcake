package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;

public class AdminMapper {
    static void addMoney(ConnectionPool connectionPool, User user, int money) throws SQLException {
        String sql = "UPDATE user SET saldo = (saldo + ?) WHERE username = ?;";

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, money);
                ps.setString(2, user.getUsername());


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
