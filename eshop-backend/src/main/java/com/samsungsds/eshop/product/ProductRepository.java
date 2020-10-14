package com.samsungsds.eshop.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
  Iterable<Product> findAllByIdIn(String[] ids);
}
