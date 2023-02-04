package com.dumbbelloper.tdd.payment.adapter;

interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
