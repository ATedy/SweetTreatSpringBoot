package com.sweetTreatSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Document(collection = "couriers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Courier {
    @Id
    private  String name;
    private double maxDeliveryMiles;
    private LocalTime startHour;
    private LocalTime endHour;
    private boolean hasRefrigeratedBox;
    private double chargePerMile;



    @Override
    public String toString() {
        return "Name: " + this.name + "\n" + "Miles: "+ this.maxDeliveryMiles + "\n" + "Charge per Mile: "+ this.chargePerMile
                + "\n" + this.hasRefrigeratedBox;
    }
}
