package com.microservice.department.mapper;

import com.microservice.department.dto.DepartmentDTO;
import com.microservice.department.entity.DepartmentServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class, componentModel = "spring", uses = DepartmentServiceEntity.class)
public interface DepartmentEntityToDto {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "departmentName", target = "departmentName")
    @Mapping(source = "departmentDescription", target = "departmentDescription")
    @Mapping(source = "departmentCode", target = "departmentCode")
    DepartmentDTO departmentEntityToDto(DepartmentServiceEntity department);
}
