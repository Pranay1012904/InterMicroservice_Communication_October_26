package com.microservice.paymentgateway.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(nullable = false)
    private String name;
    @Email
    @Column(nullable = false)
    private String email;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String phone;
    @Column(nullable = false)
    private String course;
    @Column(nullable = false)
    private String orderStatus;
    @Column(nullable = false, unique = true)
    private String razorpayOrderId;
    @Column(nullable = false)
    private Integer amount;
}
