package com.microservice.department.service.impl;

import com.microservice.department.entity.DepartmentServiceEntity;
import com.microservice.department.repository.DepartmentRepository;
import com.microservice.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentServiceEntity createDepartment(DepartmentServiceEntity department) {
        DepartmentServiceEntity savedDepartment = departmentRepository.save(department);
        return savedDepartment;
    }

    @Override
    public DepartmentServiceEntity getDepartmentByCode(String departmentCode) {

        return null;
    }
}
