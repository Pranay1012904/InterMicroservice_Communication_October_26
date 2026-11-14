package com.microservice.employee.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private boolean success;
    private EmployeeDTO employeeDto;
    private DepartmentDTO departmentDto;
}
