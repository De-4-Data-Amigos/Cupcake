package dat.backend.model.persistence;

import dat.backend.model.entities.User;

import java.sql.SQLException;

public class AdminFacade {
   public static void addMoney(ConnectionPool connectionPool, User user, int money) throws SQLException {
    AdminMapper.addMoney(connectionPool,user,money);
    }
}
