package com.sweetTreatSpringBoot.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourierErrorResponse {
    private int status;
    private String message;
    private LocalTime timeStamp;
}
