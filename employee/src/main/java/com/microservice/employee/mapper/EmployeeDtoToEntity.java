package com.microservice.employee.mapper;

import com.microservice.employee.dto.EmployeeDTO;
import com.microservice.employee.entity.EmployeeServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class, componentModel = "spring", uses = EmployeeDTO.class)
public interface EmployeeDtoToEntity {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    EmployeeServiceEntity employeeDtoToEntity(EmployeeDTO employee);
}
