package com.dumbbelloper.tdd.product;

import com.dumbbelloper.tdd.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class ProductApiTest extends ApiTest {

    @Autowired
    private ProductService productService;


    @Test
    public void 상품등록() {
        final var request = 상품등록요청_생성();
        final var response = 상품등록요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        productService.addProduct(request);
    }

    private static ExtractableResponse<Response> 상품등록요청(final AddProductRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .post("/products")
                .then()
                .log()
                .all()
                .extract();
    }

    private static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(name, price, discountPolicy);
    }

}