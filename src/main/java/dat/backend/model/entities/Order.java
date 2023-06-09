package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private int totalPrice;
    private Timestamp orderCreationTimestamp;
    private String username;
    private boolean isOrderActive;
    private int orderAmount;
    private List<CupcakeOrder> cupcakes;

    public Order(int orderId, int totalPrice, Timestamp orderCreationTimestamp, String username, boolean isOrderActive, int orderAmount) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.orderCreationTimestamp = orderCreationTimestamp;
        this.username = username;
        this.isOrderActive = isOrderActive;
        this.orderAmount = orderAmount;
        this.cupcakes = new ArrayList<>();
    }
    public Order(){
        this.totalPrice = 0;
        this.username = "guest";
        this.orderAmount = 0;
        this.cupcakes = new ArrayList<>();
    }
    public Order(User user){
        this.totalPrice = 0;
        this.username = user.getUsername();
        this.orderAmount = 0;
        this.cupcakes = new ArrayList<>();
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

    public int addCupcake(CupcakeOrder cupcake)
    {
        cupcakes.add(cupcake);
        totalPrice += cupcake.getPrice();
        orderAmount++;
        return cupcakes.indexOf(cupcake);
    }
    public void removeCupcake(int index){
        CupcakeOrder cupcake = cupcakes.get(index);
        cupcakes.remove(index);
        totalPrice -= cupcake.getPrice();
        orderAmount--;
    }


    public String getTotalPriceVAT()
    {
       return String.format("%.2f", totalPrice * 0.2);
    }

    public List<CupcakeOrder> getCupcakes()
    {
        return cupcakes;
    }

    public void setUser(User user){
        this.username = user.getUsername();
    }
}
