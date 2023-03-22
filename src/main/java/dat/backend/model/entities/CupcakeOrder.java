package dat.backend.model.entities;

public class CupcakeOrder {
    private int cupecakeOrderId;
    private int orderId;
    private int price;
    private int cupcakeTopId;
    private int cupecakeBottomId;

    public CupcakeOrder(int cupecakeOrderId, int orderId, int price, int cupcakeTopId, int cupecakeBottomId) {
        this.cupecakeOrderId = cupecakeOrderId;
        this.orderId = orderId;
        this.price = price;
        this.cupcakeTopId = cupcakeTopId;
        this.cupecakeBottomId = cupecakeBottomId;
    }

    public int getCupecakeOrderId() {
        return cupecakeOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCupcakeTopId() {
        return cupcakeTopId;
    }

    public int getCupecakeBottomId() {
        return cupecakeBottomId;
    }

    public int getPrice() {
        return price;
    }
}
