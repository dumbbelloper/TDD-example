package com.dumbbelloper.tdd.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    private final ProductService productService;
    private final ProductPort productPort;

    @Autowired
    public ProductServiceTest(ProductService productService, ProductPort productPort) {
        this.productService = productService;
        this.productPort = productPort;
    }

    @Test
    public void 상품수정() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
        productService.updateProduct(productId, request);
        final ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        final GetProductResponse productResponse = response.getBody();
        assertThat(productResponse.name()).isEqualTo("상품 수정");
        assertThat(productResponse.price()).isEqualTo(2000);
    }
}
