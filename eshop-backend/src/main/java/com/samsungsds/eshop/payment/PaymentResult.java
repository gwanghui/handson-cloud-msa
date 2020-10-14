package com.samsungsds.eshop.payment;

public class PaymentResult {
    private String paymentId;
    private Money paid;

    public PaymentResult(String paymentId, Money paid) {
        this.paymentId = paymentId;
        this.paid = paid;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Money getPaid() {
        return paid;
    }

    public void setPaid(Money paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "PaymentResult{" +
                "paymentId='" + paymentId + '\'' +
                ", paid=" + paid +
                '}';
    }
}
