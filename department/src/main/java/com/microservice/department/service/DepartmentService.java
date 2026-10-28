package com.microservice.department.service;

import com.microservice.department.dto.DepartmentDTO;
import com.microservice.department.entity.DepartmentServiceEntity;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO department);
    DepartmentDTO getDepartmentByCode(String departmentCode);
}
