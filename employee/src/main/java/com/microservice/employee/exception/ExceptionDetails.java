package com.microservice.employee.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionDetails {
    public ExceptionDetails(LocalDateTime timeStamp, String exceptionMessage, String exceptionDescription, String exceptionCode) {
        this.timeStamp = timeStamp;
        this.exceptionMessage = exceptionMessage;
        this.exceptionDescription = exceptionDescription;
        this.exceptionCode = exceptionCode;
    }

    private LocalDateTime timeStamp;
    private String exceptionMessage;
    private String exceptionDescription;
    private String exceptionCode;
}
