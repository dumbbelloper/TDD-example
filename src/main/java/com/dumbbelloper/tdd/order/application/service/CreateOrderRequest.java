package com.dumbbelloper.tdd.order.application.service;

import org.springframework.util.Assert;

public record CreateOrderRequest(Long productId, int quantity) {
    public CreateOrderRequest {
        Assert.notNull(productId, "pid not null");
        Assert.isTrue(quantity > 0, "quantity > 0");
    }
}
