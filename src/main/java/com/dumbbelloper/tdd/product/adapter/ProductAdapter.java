package com.dumbbelloper.tdd.product.adapter;

import com.dumbbelloper.tdd.product.application.port.ProductPort;
import com.dumbbelloper.tdd.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {
    private final ProductRepository productRepository;

    public ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(final Long productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("상품 x")
        );
    }
}
