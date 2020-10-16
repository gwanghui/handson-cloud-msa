package com.samsungsds.eshop.cart;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/carts")
public class CartController {
    private final CartService cartService;

    public CartController(final CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/empty")
    public ResponseEntity<Void> emptyCart() {
        cartService.emptyCart();
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> addToCart(@RequestBody CartItem cartItem) {
        cartService.addToCart(cartItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getCartItems() {
        List<CartItem> cartItems = cartService.getCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Long> getCartItemsCount() {
        Long cartItemCount = cartService.getCartItemsCount();
        return ResponseEntity.ok(cartItemCount);
    }
}
