package com.dumbbelloper.tdd.order;

import org.springframework.util.Assert;

record CreateOrderRequest(Long productId, int quantity) {
    CreateOrderRequest {
        Assert.notNull(productId, "pid not null");
        Assert.isTrue(quantity > 0, "quantity > 0");
    }
}
