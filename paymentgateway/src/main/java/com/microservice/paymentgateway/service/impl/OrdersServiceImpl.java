package com.microservice.paymentgateway.service.impl;

import com.microservice.paymentgateway.Entity.OrderDetails;
import com.microservice.paymentgateway.repository.OrdersRepository;
import com.microservice.paymentgateway.service.OrdersService;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    private OrdersRepository ordersRepository;

    @Value("${razorpay.key.id}")
    private String apiKey;
    @Value("${razorpay.secret.key}")
    private String apiSecret;

    private RazorpayClient razorpayClient;

    @Override
    public OrderDetails createOrder(OrderDetails order) throws RazorpayException {

        JSONObject jsonObject = new JSONObject();
        //amount should be in paisa
        jsonObject.put("amount", order.getAmount() * 100);
        jsonObject.put("currency", "INR");
        jsonObject.put("receipt", order.getEmail());
        this.razorpayClient = new RazorpayClient(apiKey, apiSecret);
        com.razorpay.Order razorpayOrder = razorpayClient.orders.create(jsonObject);
        System.out.println(razorpayOrder);
        order.setRazorpayOrderId(razorpayOrder.get("id"));
        order.setOrderStatus(razorpayOrder.get("status"));
        OrderDetails savedOrder = ordersRepository.save(order);
        return savedOrder;
    }
}
