package com.microservice.department.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionDetails {

    public ExceptionDetails(LocalDateTime timestamp, String exceptionMessage, String exceptionDescription, String exceptionCode) {
        this.timestamp = timestamp;
        this.exceptionMessage = exceptionMessage;
        this.exceptionDescription = exceptionDescription;
        this.exceptionCode = exceptionCode;
    }

    private LocalDateTime timestamp;
    private String exceptionMessage;
    private String exceptionDescription;
    private String exceptionCode;
}
