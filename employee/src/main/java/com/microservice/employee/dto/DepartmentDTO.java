package com.microservice.employee.dto;

import lombok.Data;

@Data
public class DepartmentDTO {

    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

}
