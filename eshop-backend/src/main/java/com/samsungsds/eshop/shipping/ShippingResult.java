package com.samsungsds.eshop.shipping;

import com.samsungsds.eshop.payment.Money;

public class ShippingResult {
    private String shippingTrackingId;
    private Money shippingCost;

    public ShippingResult(String shippingTrackingId, Money shippingCost) {
        this.shippingTrackingId = shippingTrackingId;
        this.shippingCost = shippingCost;
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

    @Override
    public String toString() {
        return "ShippingResult{" +
                "shippingTrackingId='" + shippingTrackingId + '\'' +
                ", shippingCost=" + shippingCost +
                '}';
    }
}
