package com.dumbbelloper.tdd.payment.adapter;


import com.dumbbelloper.tdd.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<Payment, Long> {

}
