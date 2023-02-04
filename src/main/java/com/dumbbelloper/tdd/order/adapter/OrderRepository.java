package com.dumbbelloper.tdd.order.adapter;

import com.dumbbelloper.tdd.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
