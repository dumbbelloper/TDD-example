package com.dumbbelloper.tdd.payment;

import com.dumbbelloper.tdd.ApiTest;
import com.dumbbelloper.tdd.order.OrderSteps;
import com.dumbbelloper.tdd.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;


public class PaymentApiTest extends ApiTest {
    @Test
    public void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());
        final var request = PaymentSteps.주문결제요청_생성();
        final var response = PaymentSteps.주문결제요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
