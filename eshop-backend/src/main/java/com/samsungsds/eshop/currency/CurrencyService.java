package com.samsungsds.eshop.currency;

import java.math.RoundingMode;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.common.math.DoubleMath;
import com.samsungsds.eshop.payment.Money;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
  private final CurrencyRepository currencyRepository;

  public CurrencyService(CurrencyRepository currencyRepository) {
    this.currencyRepository = currencyRepository;
  }

  public Map<String, Double> fetchCurrency() {
    Map<String, Double> currencyMap = Maps.newHashMap();
    currencyRepository.findAll().forEach(currency -> currencyMap.put(currency.getCurrencyCode(), currency.getCurrencyValue()));
    return currencyMap;
  }

  public Money convertMoneyCurrency(final CurrencyConvertRequest request) {
    Map<String, Double> currencies = this.fetchCurrency();
    Double fromCurrency = currencies.get(request.getFromCurrencyCode());
    Double toCurrency = currencies.get(request.getToCurrencyCode());
    // 일단 기준 통화(EUR)로 변환
    Money euros = new Money("EUR", DoubleMath.roundToLong(request.getUnits() / fromCurrency, RoundingMode.FLOOR),
        DoubleMath.roundToLong(request.getNanos() / fromCurrency, RoundingMode.HALF_DOWN));

    Money result = new Money(request.getToCurrencyCode(),
        DoubleMath.roundToLong(euros.getUnits() / toCurrency, RoundingMode.FLOOR),
        DoubleMath.roundToLong(euros.getNanos() / toCurrency, RoundingMode.HALF_DOWN));
    return result;
  }
}
