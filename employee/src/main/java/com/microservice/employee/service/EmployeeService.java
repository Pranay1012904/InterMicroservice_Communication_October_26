package com.microservice.employee.service;

import com.microservice.employee.dto.EmployeeDTO;
import com.microservice.employee.entity.EmployeeServiceEntity;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employee);
    EmployeeDTO getEmployeeById(Long empId);
}
