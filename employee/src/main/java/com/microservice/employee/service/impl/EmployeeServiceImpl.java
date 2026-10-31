package com.microservice.employee.service.impl;

import com.microservice.employee.entity.EmployeeServiceEntity;
import com.microservice.employee.repository.EmployeeRepository;
import com.microservice.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeServiceEntity createEmployee(EmployeeServiceEntity employee) {
        EmployeeServiceEntity savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }
}
