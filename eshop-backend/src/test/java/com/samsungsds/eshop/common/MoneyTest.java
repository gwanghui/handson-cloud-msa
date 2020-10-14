package com.samsungsds.eshop.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.samsungsds.eshop.payment.Money;

import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    public void testMoneyPlus() {
        Money money = new Money("USD", 1,  500000000);
        Money result = money.plus(money);
        assertEquals("USD", result.getCurrencyCode());
        assertEquals(3L, result.getUnits());
        assertEquals(0L, result.getNanos());

        Money money2 = new Money("USD", 1,  400000000);
        Money result2 = money.plus(money2);
        assertEquals("USD", result2.getCurrencyCode());
        assertEquals(2L, result2.getUnits());
        assertEquals(900000000, result2.getNanos());
    }

    @Test
    public void testMoneyMultiply() {
        Money money = new Money("USD", 1,  490000000);
        Money result = money.multiply(5);
        assertEquals("USD", result.getCurrencyCode());
        assertEquals(7L, result.getUnits());
        assertEquals(450000000, result.getNanos());

    }
}
