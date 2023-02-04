package com.dumbbelloper.tdd.order;

import com.dumbbelloper.tdd.product.DiscountPolicy;
import com.dumbbelloper.tdd.product.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice() {
        final Order order = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);
        final int totalPrice = order.getTotalPrice();
        assertThat(order.getTotalPrice()).isEqualTo(2000);
    }
}