package com.samsungsds.eshop.order;

import com.samsungsds.eshop.payment.Money;

public class OrderResult {
    private String orderId;
    private String shippingTrackingId;
    private Money shippingCost;
    private Money totalPaid;

    public OrderResult(String orderId, String shippingTrackingId, Money shippingCost, Money totalPaid) {
        this.orderId = orderId;
        this.shippingTrackingId = shippingTrackingId;
        this.shippingCost = shippingCost;
        this.totalPaid = totalPaid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShippingTrackingId() {
        return shippingTrackingId;
    }

    public void setShippingTrackingId(String shippingTrackingId) {
        this.shippingTrackingId = shippingTrackingId;
    }

    public Money getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Money shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Money getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Money totalPaid) {
        this.totalPaid = totalPaid;
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "orderId='" + orderId + '\'' +
                ", shippingTrackingId='" + shippingTrackingId + '\'' +
                ", shippingCost=" + shippingCost +
                ", totalPaid=" + totalPaid +
                '}';
    }
}
