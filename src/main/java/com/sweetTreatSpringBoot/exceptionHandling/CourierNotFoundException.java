package com.sweetTreatSpringBoot.exceptionHandling;

public class CourierNotFoundException extends RuntimeException{
    public CourierNotFoundException(String message) {
        super(message);

    }

    public CourierNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourierNotFoundException(Throwable cause) {
        super(cause);
    }
}
