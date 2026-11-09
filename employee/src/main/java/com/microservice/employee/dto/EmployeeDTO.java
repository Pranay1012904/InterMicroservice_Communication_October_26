package com.microservice.employee.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
