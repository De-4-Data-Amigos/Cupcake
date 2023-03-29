package dat.backend.model.entities;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeBottomFacade;
import dat.backend.model.persistence.CupcakeTopFacade;

public class CupcakeOrder {
    private int cupcakeOrderId;
    private int orderId;
    private int price;
    private int cupcakeTopId;
    private int cupcakeBottomId;
    private String cupcakeTopFlavor;
    private String cupcakeBottomFlavor;

    public CupcakeOrder(int cupcakeOrderId, int orderId, int price, int cupcakeTopId, int cupcakeBottomId) {
        this.cupcakeOrderId = cupcakeOrderId;
        this.orderId = orderId;
        this.price = price;
        this.cupcakeTopId = cupcakeTopId;
        this.cupcakeBottomId = cupcakeBottomId;
    }
    public CupcakeOrder(int topID, int bottomID, int topPrice, int bottomPrice ){
        cupcakeTopId = topID;
        cupcakeBottomId = bottomID;
        price = topPrice + bottomPrice;
    }
    public CupcakeOrder(int topID, int bottomID, int totalPrice ){
        cupcakeTopId = topID;
        cupcakeBottomId = bottomID;
        price = totalPrice;
    }

    public int getCupcakeOrderId() {
        return cupcakeOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCupcakeTopId() {
        return cupcakeTopId;
    }

    public int getCupcakeBottomId() {
        return cupcakeBottomId;
    }

    public String getCupcakeTopFlavor() throws DatabaseException
    {
        if(cupcakeTopFlavor == null){
            ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
            cupcakeTopFlavor = CupcakeTopFacade.getTopFlavorFromId(cupcakeTopId, connectionPool);
        }

        return cupcakeTopFlavor;
    }

    public String getCupcakeBottomFlavor() throws DatabaseException
    {
        if(cupcakeBottomFlavor == null){
            ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
            cupcakeBottomFlavor = CupcakeBottomFacade.getBottomFlavorFromId(cupcakeBottomId, connectionPool);
        }

        return cupcakeBottomFlavor;
    }

    public int getPrice() {
        return price;
    }
    public void setCupcakeTop(int id){
        cupcakeTopId = id;
    }
    public void setCupcakeBottom(int id){
        cupcakeBottomId = id;
    }
}
