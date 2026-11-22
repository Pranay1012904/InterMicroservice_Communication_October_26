package com.microservice.paymentgateway.controller;

import com.microservice.paymentgateway.Entity.OrderDetails;
import com.microservice.paymentgateway.service.OrdersService;
import com.razorpay.RazorpayException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/payment/api")
public class OrderController {

    private OrdersService ordersService;

    @GetMapping("/")
    public String init(){
        return "index";
    }

    @PostMapping("/pay")
    public ResponseEntity<OrderDetails> createOrder(@Valid @RequestBody OrderDetails order) throws RazorpayException {
        OrderDetails orderDetails = ordersService.createOrder(order);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }
}
