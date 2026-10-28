package com.microservice.department.controller;

import com.microservice.department.dto.DepartmentDTO;
import com.microservice.department.entity.DepartmentServiceEntity;
import com.microservice.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departmentService/api")
@AllArgsConstructor
public class DepartmentServiceController {

    private DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO department) {
        DepartmentDTO savedDepartment = departmentService.createDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/getDepartmentByCode/{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable(value = "department-code") String departmentCode) {
        DepartmentDTO departmentServiceDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentServiceDto, HttpStatus.FOUND);
    }
}
