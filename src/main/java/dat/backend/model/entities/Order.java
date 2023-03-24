package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int totalPrice;
    private Timestamp orderCreationTimestamp;
    private String username;
    private boolean isOrderActive;
    private int orderAmount;

    public Order(int orderId, int totalPrice, Timestamp orderCreationTimestamp, String username, boolean isOrderActive, int orderAmount) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.orderCreationTimestamp = orderCreationTimestamp;
        this.username = username;
        this.isOrderActive = isOrderActive;
        this.orderAmount = orderAmount;

    }


    public int getOrderId() {
        return orderId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Timestamp getOrderCreationTimestamp() {
        return orderCreationTimestamp;
    }

    public String getUsername() {
        return username;
    }

    public boolean isOrderActive() {
        return isOrderActive;
    }

    public int getOrderAmount() {
        return orderAmount;
    }
}
