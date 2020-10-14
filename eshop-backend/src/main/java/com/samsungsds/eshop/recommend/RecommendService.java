package com.samsungsds.eshop.recommend;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.samsungsds.eshop.product.Product;
import com.samsungsds.eshop.product.ProductService;

import org.springframework.stereotype.Service;

@Service
public class RecommendService {
  private final ProductService productService;
  
  public RecommendService(ProductService productService) {
    this.productService = productService;
  }

  public Recommendations recommendProducts() {
    Recommendations recommendations = new Recommendations();
    Product[] recommendedProducts = recommend(productService.fetchProducts().getProducts());
    recommendations.setRecommendations(recommendedProducts);
    return recommendations;
  }

  private Product[] recommend(Product[] products) {
    List<Product> productList = Lists.newArrayList(products);
    Collections.shuffle(productList);
    Product[] recommendedProducts = new Product[4];
    productList.subList(0, 4).toArray(recommendedProducts);
    return recommendedProducts;
  }

}
