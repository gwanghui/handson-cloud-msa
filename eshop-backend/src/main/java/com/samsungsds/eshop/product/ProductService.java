package com.samsungsds.eshop.product;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
  private final RestTemplate restTemplate;

  @Value("${url.productservice}")
  private String productServiceUrl;

  public ProductService(final RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }
  
  public Products fetchProducts() {
    ResponseEntity<Products> productsResponse = restTemplate.getForEntity(productServiceUrl, Products.class);
    return productsResponse.getBody();
  }

  public Product fetchProductById(final String id) {
    ResponseEntity<Product> productResponse = restTemplate.getForEntity(productServiceUrl + "/" + id, Product.class);
    return productResponse.getBody();
  }

  public Products fetchProductsByIds(final String[] ids) {
    String idsString = Stream.of(ids).collect(Collectors.joining(","));
    ResponseEntity<Products> productsResponse = restTemplate.getForEntity(productServiceUrl + "?ids=" + idsString, Products.class);
    return productsResponse.getBody();
  }
}
