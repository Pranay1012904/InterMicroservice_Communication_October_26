package com.microservice.department.controller;

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
    public ResponseEntity<DepartmentServiceEntity> createDepartment(@RequestBody DepartmentServiceEntity department) {
        DepartmentServiceEntity savedDepartment = departmentService.createDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/getDepartmentByCode/{department-code}")
    public ResponseEntity<DepartmentServiceEntity> getDepartmentByCode(@PathVariable(value = "department-code") String departmentCode) {
        DepartmentServiceEntity departmentServiceEntity = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentServiceEntity, HttpStatus.FOUND);
    }
}
