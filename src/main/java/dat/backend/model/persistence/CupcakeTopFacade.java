package dat.backend.model.persistence;

import dat.backend.model.entities.CupcakeTop;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class CupcakeTopFacade
{
    public static List<CupcakeTop> getAllTops(ConnectionPool connectionPool) throws DatabaseException
    {
        return CupcakeTopMapper.getAllTops(connectionPool);
    }
}
