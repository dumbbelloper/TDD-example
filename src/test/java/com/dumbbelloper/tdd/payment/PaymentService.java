package com.dumbbelloper.tdd.payment;

import com.dumbbelloper.tdd.order.Order;
import org.springframework.stereotype.Component;

@Component
class PaymentService {
    private final PaymentPort paymentPort;

    PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }


    public void payment(final PaymentRequest request) {
        final Order order = paymentPort.getOrder(request.orderId());
        final Payment payment = new Payment(order, request.cardNumber());
        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);
    }
}
