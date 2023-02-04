package com.dumbbelloper.tdd.order;

import com.dumbbelloper.tdd.product.DiscountPolicy;
import com.dumbbelloper.tdd.product.Product;
import com.dumbbelloper.tdd.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderPort orderPort;
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        orderPort = new OrderPort() {
            @Override
            public Product getProductById(final Long productId) {
                return new Product("상품명", 1000, DiscountPolicy.NONE);
            }

            @Override
            public void save(final Order order) {
                orderRepository.save(order);
            }
        };
        orderService = new OrderService(orderPort);
    }

    @Test
    public void 상품주문() {
        final Long productId = 1L;
        final int quantity = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
        orderService.createOrder(request);

    }


    private record CreateOrderRequest(Long productId, int quantity) {
        private CreateOrderRequest {
            Assert.notNull(productId, "pid not null");
            Assert.isTrue(quantity > 0, "quantity > 0");
        }
    }

    private class OrderService {
        private final OrderPort orderPort;

        private OrderService(final OrderPort orderPort) {
            this.orderPort = orderPort;
        }

        public void createOrder(final CreateOrderRequest request) {
            final Product product = orderPort.getProductById(request.productId());
            Order order = new Order(product, request.quantity());
            orderPort.save(order);
        }
    }

    private class OrderAdapter implements OrderPort {
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

    private class Order {
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

    private class OrderRepository {

        private final Map<Long, Order> persistence = new HashMap<>();
        private Long sequence = 0L;

        public void save(final Order order) {
            order.assignId(++sequence);
            persistence.put(order.getId(), order);
        }
    }

    private interface OrderPort {
        Product getProductById(final Long productId);

        void save(final Order order);
    }
}
