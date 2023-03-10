package com.dumbbelloper.tdd.product;

import com.dumbbelloper.tdd.product.domain.DiscountPolicy;
import com.dumbbelloper.tdd.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProductTest {
    @Test
    public void update() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        product.update("상품 수정", 2000, DiscountPolicy.NONE);
        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

    @Test
    public void none_discounted_product() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        final int discountedPrice = product.getDiscountedPrice();
        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    public void fix_discounted_product() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.FIX_1000_AMOUNT);
        final int discountedPrice = product.getDiscountedPrice();
        assertThat(discountedPrice).isEqualTo(0);
    }

}
