package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.List;

public class AdminFacade {
   public static void addMoney(ConnectionPool connectionPool, User user, int money) throws DatabaseException {
    AdminMapper.addMoney(connectionPool,user,money);
    }

    public static List<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException {
       return AdminMapper.getAllUsers(connectionPool);
    }
    public static User getUserFromUsername(ConnectionPool connectionPool, String username) throws DatabaseException{
       return AdminMapper.getUserFromUsername(connectionPool, username);
    }
}
