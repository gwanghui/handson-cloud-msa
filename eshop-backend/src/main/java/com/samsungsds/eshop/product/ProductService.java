package com.samsungsds.eshop.product;

import com.google.common.collect.Iterables;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
  
  public Products fetchProducts() {
    return new Products(Iterables.toArray(productRepository.findAll(), Product.class));
  }

  public Product fetchProductById(final String id) {
    return productRepository.findById(id).orElse(null);
  }

  public Products fetchProductsByIds(final String[] ids) {
    return new Products(Iterables.toArray(productRepository.findAllByIdIn(ids), Product.class));
    // Product[] products = this.fetchProducts().getProducts();
    // Product[] cartProducts = Stream.of(products).filter(product -> {
    //   return Arrays.stream(ids).anyMatch(product.getId()::equals);
    // }).toArray(Product[]::new);
    // Products result = new Products();
    // result.setProducts(cartProducts);
    // return result;
  }

}
