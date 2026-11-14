package com.microservice.employee.service.impl;

import com.microservice.employee.dto.DepartmentDTO;
import com.microservice.employee.dto.EmployeeDTO;
import com.microservice.employee.dto.ResponseDTO;
import com.microservice.employee.entity.EmployeeServiceEntity;
import com.microservice.employee.exception.ResourceNotFoundException;
import com.microservice.employee.mapper.EmployeeDtoToEntity;
import com.microservice.employee.mapper.EmployeeEntityToDto;
import com.microservice.employee.repository.EmployeeRepository;
import com.microservice.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeEntityToDto employeeEntityToDto, EmployeeDtoToEntity employeeDtoToEntity, RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.employeeEntityToDto = employeeEntityToDto;
        this.employeeDtoToEntity = employeeDtoToEntity;
        this.restTemplate = restTemplate;
    }

    private EmployeeRepository employeeRepository;
    private EmployeeEntityToDto employeeEntityToDto;
    private EmployeeDtoToEntity employeeDtoToEntity;
    private RestTemplate restTemplate;
    @Value("${url.protocol}")
    private String protocol;
    @Value("${url.host}")
    private String host;
    @Value("${url.port}")
    private String port;
    @Value("${url.path}")
    private String path;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employee) {
        EmployeeServiceEntity savedEmployee = employeeRepository.save(employeeDtoToEntity.employeeDtoToEntity(employee));
        return employeeEntityToDto.employeeEntityToDto(savedEmployee);
    }

    @Override
    public ResponseDTO getEmployeeById(Long empId) {

        EmployeeServiceEntity fetchedEmp = employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException(
                String.format("Employee With ID :: %d not found.", empId)
        ));
        ResponseEntity<DepartmentDTO> departmentResponse = restTemplate.getForEntity(protocol + host + port + path + fetchedEmp.getDepartmentCode(), DepartmentDTO.class);
        DepartmentDTO departmentBody = departmentResponse.getBody();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccess(true);
        responseDTO.setEmployeeDto(employeeEntityToDto.employeeEntityToDto(fetchedEmp));
        responseDTO.setDepartmentDto(departmentBody);
        return responseDTO;
    }
}
