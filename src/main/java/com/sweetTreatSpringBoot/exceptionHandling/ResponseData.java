package com.sweetTreatSpringBoot.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private int status;
    private String message;
}
