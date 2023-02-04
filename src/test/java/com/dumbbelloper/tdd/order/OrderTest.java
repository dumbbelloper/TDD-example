package com.dumbbelloper.tdd.order;

import com.dumbbelloper.tdd.order.domain.Order;
import com.dumbbelloper.tdd.product.domain.DiscountPolicy;
import com.dumbbelloper.tdd.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice() {
        final Order order = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);
        final int totalPrice = order.getTotalPrice();
        assertThat(order.getTotalPrice()).isEqualTo(2000);
    }
}