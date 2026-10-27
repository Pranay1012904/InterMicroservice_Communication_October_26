package com.microservice.department.repository;

import com.microservice.department.entity.DepartmentServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentServiceEntity, Long> {
    DepartmentServiceEntity getDepartmentByDepartmentCode(String departmentCode);
}
