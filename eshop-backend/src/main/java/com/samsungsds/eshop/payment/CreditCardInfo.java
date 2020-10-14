package com.samsungsds.eshop.payment;

public class CreditCardInfo {
    private String creditCardNumber;
    private int cvv;
    private int creditCardExpirationYear;
    private int creditCardExpirationMonth;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getCreditCardExpirationYear() {
        return creditCardExpirationYear;
    }

    public void setCreditCardExpirationYear(int creditCardExpirationYear) {
        this.creditCardExpirationYear = creditCardExpirationYear;
    }

    public int getCreditCardExpirationMonth() {
        return creditCardExpirationMonth;
    }

    public void setCreditCardExpirationMonth(int creditCardExpirationMonth) {
        this.creditCardExpirationMonth = creditCardExpirationMonth;
    }

    @Override
    public String toString() {
        return "CreditCardInfo{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", cvv=" + cvv +
                ", creditCardExpirationYear=" + creditCardExpirationYear +
                ", creditCardExpirationMonth=" + creditCardExpirationMonth +
                '}';
    }
}
