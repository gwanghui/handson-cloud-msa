package com.samsungsds.eshop.order;

import java.util.stream.Stream;

import com.google.common.collect.Iterables;
import com.samsungsds.eshop.cart.CartItem;
import com.samsungsds.eshop.cart.CartService;
import com.samsungsds.eshop.payment.Money;
import com.samsungsds.eshop.payment.PaymentRequest;
import com.samsungsds.eshop.payment.PaymentService;
import com.samsungsds.eshop.product.Product;
import com.samsungsds.eshop.product.ProductService;
import com.samsungsds.eshop.shipping.ShippingRequest;
import com.samsungsds.eshop.shipping.ShippingResult;
import com.samsungsds.eshop.shipping.ShippingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/checkouts")
public class OrderController {
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;
    private final ShippingService shippingService;
    private final CartService cartService;
    private final PaymentService paymentService;
    private final ProductService productService;

    public OrderController(final OrderService orderService, 
    final ShippingService shippingService,
    final  PaymentService paymentService,
    final CartService cartService,
    final ProductService productService) {
        this.orderService = orderService;
        this.shippingService = shippingService;
        this.paymentService = paymentService;
        this.cartService = cartService;
        this.productService = productService;
    }

    @PostMapping(value = "/orders")
    public ResponseEntity<OrderResult> placeOrder(@RequestBody OrderRequest orderRequest) {
        logger.info("placeOrder : " + orderRequest);

        // cart 조회
        CartItem[] cartItems = Iterables.toArray(cartService.getCartItems(), CartItem.class);


        // cart 상품 조회
        Product[] products = getProducts(cartItems);

        // 상품 가격 합계 계산
        Money itemPrice = orderService.calculateItemPrice(cartItems, products);
        logger.info("total item price : " + itemPrice);

        // 예상 배송비 계산
        Money shippingCost = shippingService.calculateShippingCostFromCartItems(cartItems);

        // 결제 요청
        PaymentRequest request = new PaymentRequest(orderRequest.getCreditCardInfo(), itemPrice.plus(shippingCost));
        paymentService.requestPayment(request);

        // 배송 요청
        ShippingResult shippingResult = shippingService
                .shipOrder(new ShippingRequest(cartItems, orderRequest.getAddress()));
        logger.info("shippingCost : " + shippingResult.getShippingCost());

        // 총액 계산
        Money totalCost = itemPrice.plus(shippingResult.getShippingCost());

        // 주문ID 생성
        String orderId = orderService.createOrderId(orderRequest);

        // 카트 비우기
        cartService.emptyCart();
        return ResponseEntity.ok(new OrderResult(orderId, shippingResult.getShippingTrackingId(),
                shippingResult.getShippingCost(), totalCost));
    }

    private Product[] getProducts(CartItem[] cartItems) {
        String[] cartItemIds = Stream.of(cartItems).map(CartItem::getId).toArray(String[]::new);
        return productService.fetchProductsByIds(cartItemIds).getProducts();
    }
}
