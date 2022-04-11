package com.sweetTreatSpringBoot.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

public class ErrorHandlingMethod {
    // exception handler method for courier
    @ExceptionHandler
    public ResponseEntity<CourierErrorResponse> handleException(CourierNotFoundException exc) {
        CourierErrorResponse error = new CourierErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(LocalTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
