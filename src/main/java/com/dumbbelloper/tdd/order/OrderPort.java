package com.dumbbelloper.tdd.order;

import com.dumbbelloper.tdd.product.Product;

interface OrderPort {
    Product getProductById(final Long productId);

    void save(final Order order);
}
