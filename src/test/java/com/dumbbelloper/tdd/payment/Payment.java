package com.dumbbelloper.tdd.payment;

import com.dumbbelloper.tdd.order.Order;
import org.springframework.util.Assert;

class Payment {
    private Long id;
    private final Order order;
    private final String cardNumber;

    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "order is not null");
        Assert.hasText(cardNumber, "cardNumber is not null");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
