package com.microservice.employee.service;

import com.microservice.employee.entity.EmployeeServiceEntity;

public interface EmployeeService {
    EmployeeServiceEntity createEmployee(EmployeeServiceEntity employee);
}
