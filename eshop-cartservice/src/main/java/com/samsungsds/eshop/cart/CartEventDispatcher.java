package com.samsungsds.eshop.cart;

import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;

@Service
public class CartEventDispatcher {
    private final Logger logger = LoggerFactory.getLogger(CartEventDispatcher.class);
    private final Connection natsConnection;
    private final CartService cartService;

    public CartEventDispatcher(Connection natsConnection, CartService cartService) {
      this.natsConnection = natsConnection;
      this.cartService = cartService;
    }

    @PostConstruct
    public void initialize() {
        try {
            Dispatcher messageDispatcher = natsConnection.createDispatcher((msg) -> {
                String messageDataString = new String(msg.getData(), StandardCharsets.UTF_8);
                logger.info("NATS message received [{}] : {}", msg.getSubject(), messageDataString);
                OrderPlaced orderPlaced = new Gson().fromJson(messageDataString, OrderPlaced.class);
                // empty cart
                logger.info("empty Cart : {}", orderPlaced.getOrderId());
                cartService.emptyCart();
            });
            messageDispatcher.subscribe("order.placed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
}
