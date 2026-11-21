package com.microservice.paymentgateway.service;

import com.microservice.paymentgateway.Entity.OrderDetails;
import com.razorpay.RazorpayException;

public interface OrdersService {

    OrderDetails createOrder(OrderDetails order)throws RazorpayException;
}
