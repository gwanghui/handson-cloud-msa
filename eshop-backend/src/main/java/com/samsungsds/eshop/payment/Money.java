package com.samsungsds.eshop.payment;

import java.util.Objects;

public class Money {
    private static final long NANO = 1000000000;
    private String currencyCode;
    private long units;
    private long nanos;

    public Money() {
        this.currencyCode = "USD";
        this.units = 0L;
        this.nanos = 0L;
    }

    public Money(String currencyCode, long units, long nanos) {
        this.currencyCode = currencyCode;
        this.units = units;
        this.nanos = nanos;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public long getUnits() {
        return units;
    }

    public void setUnits(long units) {
        this.units = units;
    }

    public long getNanos() {
        return nanos;
    }

    public void setNanos(long nanos) {
        this.nanos = nanos;
    }

    public Money plus(final Money amount) {
        if (amount == null) return this;
        if (!this.currencyCode.equals(amount.currencyCode)) {
            throw new IllegalArgumentException("different currencies");
        }
        long nanos = this.getNanos() + amount.getNanos();
        long units = this.getUnits() + amount.getUnits();
        // 받아올림
        if (nanos >= Money.NANO) {
            units += Math.floorDiv(nanos, Money.NANO);
            nanos = Math.floorMod(nanos, Money.NANO);
        }
        return new Money(this.currencyCode, units, nanos);
    }

    public Money multiply(final long times) {
        long nanos = this.getNanos() * times;
        long units = this.getUnits() * times;
        // 받아올림
        if (nanos >= Money.NANO) {
            units += Math.floorDiv(nanos, Money.NANO);
            nanos = Math.floorMod(nanos, Money.NANO);
        }
        return new Money(this.currencyCode, units, nanos);
    }

    @Override
    public String toString() {
        return "Money{" +
                "currencyCode='" + currencyCode + '\'' +
                ", units=" + units +
                ", nanos=" + nanos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Money)) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(currencyCode, money.currencyCode) && units == money.units && nanos == money.nanos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCode, units, nanos);
    }

}
