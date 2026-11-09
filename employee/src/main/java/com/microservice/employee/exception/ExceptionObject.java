package com.microservice.employee.exception;

import lombok.Data;

import java.util.List;

@Data
public class ExceptionObject {

    public ExceptionObject(boolean success, List<ExceptionDetails> exceptionDetailsList) {
        this.success = success;
        this.exceptionDetailsList = exceptionDetailsList;
    }

    private boolean success;
    private List<ExceptionDetails> exceptionDetailsList;
}
