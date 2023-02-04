package com.dumbbelloper.tdd.product.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private DiscountPolicy discountPolicy;

    public Product(final String name, final int price, final DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명을 입력해 주세요.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(discountPolicy, "할인 정책을 입력해 주세요.");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void update(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명을 입력해 주세요.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(discountPolicy, "할인 정책을 입력해 주세요.");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public int getDiscountedPrice() {
        return discountPolicy.applyDiscount(price);
    }

}
