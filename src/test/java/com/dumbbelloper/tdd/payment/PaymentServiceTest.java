package com.dumbbelloper.tdd.payment;

import com.dumbbelloper.tdd.order.OrderService;
import com.dumbbelloper.tdd.order.OrderSteps;
import com.dumbbelloper.tdd.product.ProductService;
import com.dumbbelloper.tdd.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PaymentServiceTest {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @Test
    public void 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        orderService.createOrder(OrderSteps.상품주문요청_생성());
        final PaymentRequest request = PaymentSteps.주문결제요청_생성();
        paymentService.payment(request);
    }

}
