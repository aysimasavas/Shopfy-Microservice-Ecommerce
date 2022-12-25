package com.aysimasavas.orderservice.repository;

import com.aysimasavas.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
