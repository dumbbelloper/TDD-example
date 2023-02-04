package com.dumbbelloper.tdd.payment;

import com.dumbbelloper.tdd.order.Order;

interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
