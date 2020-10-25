package com.samsungsds.eshop.cart;

import java.util.List;

import com.google.common.collect.Lists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final Logger logger = LoggerFactory.getLogger(CartService.class);
    private final RestTemplate restTemplate;

    @Value("${url.cartservice}")
    private String cartServiceUrl;

    public CartService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void emptyCart() {
        logger.info("emptyCart()");
        String emptyCartUrl = cartServiceUrl + "/empty";
        restTemplate.postForEntity(emptyCartUrl, null,  Void.class);
    }

    public void addToCart(final CartItem cartItem) {
        logger.info("addToCart() : {}", cartItem);
        restTemplate.postForEntity(cartServiceUrl, cartItem,  CartItem.class);
    }

    public List<CartItem> getCartItems() {
        logger.info("getCartItems()");
        ResponseEntity<CartItem[]> cartItemsResponse = restTemplate.getForEntity(cartServiceUrl, CartItem[].class);
        return Lists.newArrayList(cartItemsResponse.getBody());
    }

    public Long getCartItemsCount() {
        logger.info("getCartItemsCount()");
        String cartItemsCountUrl = cartServiceUrl + "/count";
        ResponseEntity<Long> cartItemsCountResponse = restTemplate.getForEntity(cartItemsCountUrl, Long.class);
        return cartItemsCountResponse.getBody();
    }
}
