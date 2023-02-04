package com.dumbbelloper.tdd.order;

import com.dumbbelloper.tdd.product.Product;
import org.springframework.util.Assert;

class Order {
    private Long id;
    private final Product product;
    private final int quantity;

    public Order(final Product product, final int quantity) {
        Assert.notNull(product, "상품은 필수");
        Assert.isTrue(quantity > 0, "quantity > 0");
        this.product = product;
        this.quantity = quantity;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
