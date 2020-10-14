package com.samsungsds.eshop.product;

import java.util.Arrays;

public class Products {
    private Product[] products;

    public Product[] getProducts() {
        return products;
    }

    public Products(Product[] products) {
        this.products = products;
    }
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CartProductResponse{" +
                "products=" + Arrays.toString(products) +
                '}';
    }
}
