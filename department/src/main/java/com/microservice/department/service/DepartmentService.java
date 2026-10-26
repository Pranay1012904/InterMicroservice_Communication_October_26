package com.microservice.department.service;

import com.microservice.department.entity.DepartmentServiceEntity;

public interface DepartmentService {
    DepartmentServiceEntity createDepartment(DepartmentServiceEntity department);
    DepartmentServiceEntity getDepartmentByCode(String departmentCode);
}
