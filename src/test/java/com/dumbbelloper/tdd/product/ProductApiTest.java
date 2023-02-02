package com.dumbbelloper.tdd.product;

import com.dumbbelloper.tdd.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class ProductApiTest extends ApiTest {

    @Autowired
    private ProductService productService;


    @Test
    public void 상품등록() {
        final var request = ProductSteps.상품등록요청_생성();
        final var response = ProductSteps.상품등록요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        productService.addProduct(request);
    }

}
