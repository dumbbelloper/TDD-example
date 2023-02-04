package com.dumbbelloper.tdd.product.application.port;

import com.dumbbelloper.tdd.product.domain.Product;

public interface ProductPort {
    void save(final Product product);
    Product getProduct(Long productId);
}
