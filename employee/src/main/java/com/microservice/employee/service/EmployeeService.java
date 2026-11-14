package com.microservice.employee.service;

import com.microservice.employee.dto.EmployeeDTO;
import com.microservice.employee.dto.ResponseDTO;
import com.microservice.employee.entity.EmployeeServiceEntity;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employee);
    ResponseDTO getEmployeeById(Long empId);
}
