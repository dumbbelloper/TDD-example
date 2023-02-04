package com.dumbbelloper.tdd.payment.application.service;

import org.springframework.util.Assert;

public record PaymentRequest(Long orderId, String cardNumber) {
    public PaymentRequest {
        Assert.notNull(orderId, "id is not null");
        Assert.hasText(cardNumber, "cardNumber is not null");
    }
}
