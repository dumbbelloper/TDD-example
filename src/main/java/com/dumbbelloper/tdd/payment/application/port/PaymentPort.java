package com.dumbbelloper.tdd.payment.application.port;

import com.dumbbelloper.tdd.order.domain.Order;
import com.dumbbelloper.tdd.payment.domain.Payment;

public interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
