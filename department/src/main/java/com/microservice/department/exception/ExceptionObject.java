package com.microservice.department.exception;

import lombok.Data;

import java.util.List;

@Data
public class ExceptionObject {

    public ExceptionObject(Boolean success, List<ExceptionDetails> exceptionDetailsList) {
        this.success = success;
        this.exceptionDetailsList = exceptionDetailsList;
    }

    private Boolean success;
    private List<ExceptionDetails> exceptionDetailsList;
}
