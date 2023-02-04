package com.dumbbelloper.tdd.product.adapter;

import com.dumbbelloper.tdd.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
