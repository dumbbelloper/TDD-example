package com.dumbbelloper.tdd.payment.domain;

import com.dumbbelloper.tdd.order.domain.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public
class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Order order;
    private String cardNumber;

    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "order is not null");
        Assert.hasText(cardNumber, "cardNumber is not null");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }
}
