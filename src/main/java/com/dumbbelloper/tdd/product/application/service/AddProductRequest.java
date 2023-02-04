package com.dumbbelloper.tdd.product.application.service;

import com.dumbbelloper.tdd.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    public AddProductRequest {
        Assert.hasText(name, "상품명을 입력해 주세요.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(discountPolicy, "할인 정책을 입력해 주세요.");
    }
}
