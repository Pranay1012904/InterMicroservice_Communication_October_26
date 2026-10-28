package com.microservice.department.mapper;

import com.microservice.department.dto.DepartmentDTO;
import com.microservice.department.entity.DepartmentServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class, componentModel = "spring", uses = DepartmentDTO.class)
public interface DepartmentDtoToEntity {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "departmentName", target = "departmentName")
    @Mapping(source = "departmentDescription", target = "departmentDescription")
    @Mapping(source = "departmentCode", target = "departmentCode")
    DepartmentServiceEntity departmentDtoToEntity(DepartmentDTO department);
}
