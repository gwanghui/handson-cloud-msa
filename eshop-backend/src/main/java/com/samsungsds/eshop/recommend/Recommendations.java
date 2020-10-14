package com.samsungsds.eshop.recommend;

import com.samsungsds.eshop.product.Product;

public class Recommendations {
  private Product[] recommendations;


  public Product[] getRecommendations() {
    return this.recommendations;
  }

  public void setRecommendations(Product[] recommendations) {
    this.recommendations = recommendations;
  }

  @Override
  public String toString() {
    return "{" +
      " recommendations='" + getRecommendations() + "'" +
      "}";
  }

}