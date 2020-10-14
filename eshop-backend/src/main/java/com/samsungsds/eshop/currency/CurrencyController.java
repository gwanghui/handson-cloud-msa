package com.samsungsds.eshop.currency;

import java.util.Map;

import com.samsungsds.eshop.payment.Money;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/currencies")
public class CurrencyController {
  private final CurrencyService currencyService;

  public CurrencyController(final CurrencyService currencyService) {
    this.currencyService = currencyService;
  }

  @GetMapping
  public ResponseEntity<Map<String, Double>> fetchCurrencyMap() {
    Map<String, Double> currencies = null;
    try {
      currencies = currencyService.fetchCurrency();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(currencies);
    }
    return ResponseEntity.ok(currencies);
  }

  @PostMapping(value = "/convert")
  public ResponseEntity<Money> convertMoneyCurrency(@RequestBody CurrencyConvertRequest request) {
    return ResponseEntity.ok(currencyService.convertMoneyCurrency(request));
  }

}
