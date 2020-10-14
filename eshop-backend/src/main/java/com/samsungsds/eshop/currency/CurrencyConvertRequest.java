package com.samsungsds.eshop.currency;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyConvertRequest {
  @JsonProperty(value="currencyCode")
  private String fromCurrencyCode;

  @JsonProperty(value="to_code")
  private String toCurrencyCode;

  private Double units;
  private Double nanos;
  

  public CurrencyConvertRequest() {
  }

  public CurrencyConvertRequest(String fromCurrencyCode, String toCurrencyCode, Double units, Double nanos) {
    this.fromCurrencyCode = fromCurrencyCode;
    this.toCurrencyCode = toCurrencyCode;
    this.units = units;
    this.nanos = nanos;
  }

  public String getFromCurrencyCode() {
    return this.fromCurrencyCode;
  }

  public void setFromCurrencyCode(String fromCurrencyCode) {
    this.fromCurrencyCode = fromCurrencyCode;
  }

  public String getToCurrencyCode() {
    return this.toCurrencyCode;
  }

  public void setToCurrencyCode(String toCurrencyCode) {
    this.toCurrencyCode = toCurrencyCode;
  }

  public Double getUnits() {
    return this.units;
  }

  public void setUnits(Double units) {
    this.units = units;
  }

  public Double getNanos() {
    return this.nanos;
  }

  public void setNanos(Double nanos) {
    this.nanos = nanos;
  }

  @Override
  public String toString() {
    return "{" +
      " fromCurrencyCode='" + getFromCurrencyCode() + "'" +
      ", toCurrencyCode='" + getToCurrencyCode() + "'" +
      ", units='" + getUnits() + "'" +
      ", nanos='" + getNanos() + "'" +
      "}";
  }
  
}
