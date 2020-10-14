package com.samsungsds.eshop.payment;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money, String> {
  @Override
  public String convertToDatabaseColumn(Money money) {
    return money.getCurrencyCode() + "|" + money.getUnits() + "|" + money.getNanos();
  }

  @Override
  public Money convertToEntityAttribute(String dbData) {
    String[] data = dbData.split("\\|");
    String currencyCode = data[0];
    long units = Long.parseLong(data[1]);
    long nanos = Long.parseLong(data[2]);
    return new Money(currencyCode, units, nanos);
  }
}
