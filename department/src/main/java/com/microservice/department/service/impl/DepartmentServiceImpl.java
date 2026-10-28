package com.microservice.department.service.impl;

import com.microservice.department.dto.DepartmentDTO;
import com.microservice.department.entity.DepartmentServiceEntity;
import com.microservice.department.exception.ResourceNotFoundException;
import com.microservice.department.mapper.DepartmentDtoToEntity;
import com.microservice.department.mapper.DepartmentEntityToDto;
import com.microservice.department.repository.DepartmentRepository;
import com.microservice.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentDtoToEntity departmentDtoToEntity;
    private DepartmentEntityToDto departmentEntityToDto;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO department) {
        DepartmentServiceEntity savedDepartment = departmentRepository.save(departmentDtoToEntity.departmentDtoToEntity(department));
        return departmentEntityToDto.departmentEntityToDto(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Optional<DepartmentServiceEntity> fetchedEntity = Optional.ofNullable(departmentRepository.getDepartmentByDepartmentCode(departmentCode));
        if(fetchedEntity.isEmpty()){
            throw new ResourceNotFoundException(String.format("DEPARTMENT WITH CODE %s NOT FOUND!", departmentCode));
        }
        return departmentEntityToDto.departmentEntityToDto(fetchedEntity.get());
    }
}
