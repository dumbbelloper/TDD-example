package com.dumbbelloper.tdd.order.application.port;

import com.dumbbelloper.tdd.order.domain.Order;
import com.dumbbelloper.tdd.product.domain.Product;

public interface OrderPort {
    Product getProductById(final Long productId);

    void save(final Order order);
}
