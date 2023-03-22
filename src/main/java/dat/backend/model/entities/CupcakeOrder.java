package dat.backend.model.entities;

import java.sql.Timestamp;

public class CupcakeOrder {
    private int cupcakeOrderId;
    private int orderId;
    private int price;
    private int cupcakeTopId;
    private int cupcakeBottomId;

    public CupcakeOrder(int cupcakeOrderId, int orderId, int price, int cupcakeTopId, int cupcakeBottomId) {
        this.cupcakeOrderId = cupcakeOrderId;
        this.orderId = orderId;
        this.price = price;
        this.cupcakeTopId = cupcakeTopId;
        this.cupcakeBottomId = cupcakeBottomId;
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

    public int getPrice() {
        return price;
    }
}
