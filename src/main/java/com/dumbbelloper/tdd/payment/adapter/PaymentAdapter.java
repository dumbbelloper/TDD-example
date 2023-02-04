package com.dumbbelloper.tdd.payment.adapter;

import com.dumbbelloper.tdd.order.domain.Order;
import com.dumbbelloper.tdd.order.adapter.OrderRepository;
import com.dumbbelloper.tdd.payment.application.port.PaymentPort;
import com.dumbbelloper.tdd.payment.domain.Payment;
import org.springframework.stereotype.Component;

@Component
class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(
                () -> new IllegalArgumentException("주문이 존재하지 않음.")
        );
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
