package com.samsungsds.eshop.order;

public class OrderPlaced {
    private String orderId;
 
    public OrderPlaced(String orderId) {
        this.orderId = orderId;
    }
 
    public String getOrderId() {
        return orderId;
    }
 
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
 
    @Override
    public String toString() {
        return "OrderPlaced{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}
