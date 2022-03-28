package com.sweetTreatSpringBoot.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private LocalTime orderHour;
    private double customerDistance;
    private boolean IsRefrigerated;

}

