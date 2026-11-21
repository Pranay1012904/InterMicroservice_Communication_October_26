package com.microservice.paymentgateway.repository;

import com.microservice.paymentgateway.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrderDetails,Integer> {
}
