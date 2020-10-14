package com.samsungsds.eshop.currency;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String currencyCode;

  @Column(nullable = false)
  private Double currencyValue;


  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCurrencyCode() {
    return this.currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Double getCurrencyValue() {
    return this.currencyValue;
  }

  public void setCurrencyValue(Double currencyValue) {
    this.currencyValue = currencyValue;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", currencyCode='" + getCurrencyCode() + "'" +
      ", currencyValue='" + getCurrencyValue() + "'" +
      "}";
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Currency)) {
            return false;
        }
        Currency currency = (Currency) o;
        return Objects.equals(id, currency.id) && Objects.equals(currencyCode, currency.currencyCode) && Objects.equals(currencyValue, currency.currencyValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, currencyCode, currencyValue);
  }

}
