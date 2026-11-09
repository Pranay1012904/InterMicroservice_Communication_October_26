package com.microservice.employee.controller;

import com.microservice.employee.dto.EmployeeDTO;
import com.microservice.employee.entity.EmployeeServiceEntity;
import com.microservice.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employee/api")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(value = "id") long empId) {
        EmployeeDTO fetchedEmp = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(fetchedEmp,HttpStatus.FOUND);
    }
}
