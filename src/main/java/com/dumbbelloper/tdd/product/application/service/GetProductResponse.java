package com.dumbbelloper.tdd.product.application.service;

import com.dumbbelloper.tdd.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record GetProductResponse(long id, String name, int price, DiscountPolicy discountPolicy) {
    public GetProductResponse {
        Assert.notNull(id, "id is not null");
        Assert.notNull(name, "name is not null");
        Assert.notNull(discountPolicy, "price is not null");
    }
}