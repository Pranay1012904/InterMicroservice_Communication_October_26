package com.microservice.employee.repository;

import com.microservice.employee.entity.EmployeeServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeServiceEntity, Long> {
}
