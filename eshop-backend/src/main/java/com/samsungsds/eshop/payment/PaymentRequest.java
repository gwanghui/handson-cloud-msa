package com.samsungsds.eshop.payment;

public class PaymentRequest {
    private CreditCardInfo creditCardInfo;
    private Money amount;

    public PaymentRequest(CreditCardInfo creditCardInfo, Money amount) {
        this.creditCardInfo = creditCardInfo;
        this.amount = amount;
    }

    public CreditCardInfo getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "creditCardInfo=" + creditCardInfo +
                ", amount=" + amount +
                '}';
    }
}
