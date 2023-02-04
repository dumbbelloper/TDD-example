package com.dumbbelloper.tdd.order;

import com.dumbbelloper.tdd.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private int quantity;

    public Order(final Product product, final int quantity) {
        Assert.notNull(product, "상품은 필수");
        Assert.isTrue(quantity > 0, "quantity > 0");
        this.product = product;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return product.getDiscountedPrice() * quantity;
    }
}
