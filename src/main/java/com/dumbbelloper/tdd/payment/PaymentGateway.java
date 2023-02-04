package com.dumbbelloper.tdd.payment;

interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
