package com.samsungsds.eshop.payment;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    public PaymentResult requestPayment(PaymentRequest request) {
        String paymentId = createPaymentId();
        pay();
        return new PaymentResult(paymentId, request.getAmount());
    }

    private void pay() {
        // 실제로 결제 요청을 해야 하지만 예제이므로 패스
    }

    private String createPaymentId() {
        // 원래는 뭔가 많이 해야 하지만 예제이므로 그냥 UUID
        return "PAYMENT-" + UUID.randomUUID().toString();
    }
}
