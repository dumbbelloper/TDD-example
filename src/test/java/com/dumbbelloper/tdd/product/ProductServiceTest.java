package com.dumbbelloper.tdd.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void 상품조회() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final long productId = 1L;

        final GetProductResponse response = productService.getProduct(productId);

        assertThat(response).isNotNull();
    }

}
