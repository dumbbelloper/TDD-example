package com.dumbbelloper.tdd.order.adapter;

import com.dumbbelloper.tdd.order.application.port.OrderPort;
import com.dumbbelloper.tdd.order.domain.Order;
import com.dumbbelloper.tdd.product.domain.Product;
import com.dumbbelloper.tdd.product.adapter.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }


    public Product getProductById(final Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품 없음."));
    }

    public void save(Order order) {
        orderRepository.save(order);
    }
}
