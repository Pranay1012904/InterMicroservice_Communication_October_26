package com.microservice.paymentgateway.controller;

import com.microservice.paymentgateway.Entity.OrderDetails;
import com.microservice.paymentgateway.service.OrdersService;
import com.razorpay.RazorpayException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/payment/api")
public class OrderController {

    private OrdersService ordersService;

    @PostMapping("/pay")
    public ResponseEntity<OrderDetails> createOrder(@Valid @RequestBody OrderDetails order) throws RazorpayException {
        OrderDetails orderDetails = ordersService.createOrder(order);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }
}
