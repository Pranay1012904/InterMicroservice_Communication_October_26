package com.microservice.employee.service.impl;

import com.microservice.employee.dto.EmployeeDTO;
import com.microservice.employee.entity.EmployeeServiceEntity;
import com.microservice.employee.exception.ResourceNotFoundException;
import com.microservice.employee.mapper.EmployeeDtoToEntity;
import com.microservice.employee.mapper.EmployeeEntityToDto;
import com.microservice.employee.repository.EmployeeRepository;
import com.microservice.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeEntityToDto employeeEntityToDto;
    private EmployeeDtoToEntity employeeDtoToEntity;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employee) {
        EmployeeServiceEntity savedEmployee = employeeRepository.save(employeeDtoToEntity.employeeDtoToEntity(employee));
        return employeeEntityToDto.employeeEntityToDto(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long empId) {

        EmployeeServiceEntity fetchedEmp= employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException(
                String.format("Employee With ID :: %d not found.",empId)
        ));
        return employeeEntityToDto.employeeEntityToDto(fetchedEmp);
    }
}
