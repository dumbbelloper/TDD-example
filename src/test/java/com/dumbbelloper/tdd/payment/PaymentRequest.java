package com.dumbbelloper.tdd.payment;

import org.springframework.util.Assert;

record PaymentRequest(Long orderId, String cardNumber) {
    PaymentRequest {
        Assert.notNull(orderId, "id is not null");
        Assert.hasText(cardNumber, "cardNumber is not null");
    }
}
