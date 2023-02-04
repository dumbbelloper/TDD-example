package com.dumbbelloper.tdd.product.application.service;

import com.dumbbelloper.tdd.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    public UpdateProductRequest {
        Assert.hasText(name, "상품명 필수");
        Assert.isTrue(price > 0, "가격은 0보다 커야");
        Assert.notNull(discountPolicy, "할인 정책은 필수");
    }
}
