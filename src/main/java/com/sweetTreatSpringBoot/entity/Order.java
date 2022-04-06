package com.sweetTreatSpringBoot.entity;
import lombok.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class Order {
    private LocalTime orderHour;
    private double customerDistance;
    private boolean IsRefrigerated;

}

