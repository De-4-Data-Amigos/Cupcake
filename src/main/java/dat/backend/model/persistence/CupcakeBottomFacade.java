package dat.backend.model.persistence;

import dat.backend.model.entities.CupcakeBottom;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class CupcakeBottomFacade
{
    public static List<CupcakeBottom> getAllBottoms(ConnectionPool connectionPool) throws DatabaseException
    {
        return CupcakeBottomMapper.getAllBottoms(connectionPool);
    }
    public static CupcakeBottom getButtomFromId(int bottom_id, ConnectionPool connectionPool) throws DatabaseException
    {
        return CupcakeBottomMapper.getButtomFromId(bottom_id, connectionPool);
    }
}