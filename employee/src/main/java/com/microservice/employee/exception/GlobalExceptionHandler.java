package com.microservice.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionObject> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest req) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                req.getDescription(false),
                "RESOURCE_NOT_FOUND"
        );
        List<ExceptionDetails> exceptionDetailsList = new ArrayList<>();
        exceptionDetailsList.add(exceptionDetails);
        ExceptionObject exceptionObject = new ExceptionObject(
                false,
                exceptionDetailsList
        );
        return new ResponseEntity<>(exceptionObject, HttpStatus.NOT_FOUND);
    }

}
