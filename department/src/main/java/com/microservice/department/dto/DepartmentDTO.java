package com.microservice.department.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DepartmentDTO {

    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

}
