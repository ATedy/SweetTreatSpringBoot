package com.sweetTreatSpringBoot.couriers;

import org.hibernate.annotations.Generated;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Courier {
    private int id;
    private String name;
    private double maxDeliveryMiles;
    private LocalTime startHour;
    private LocalTime endHour;
    private boolean hasRefrigeratedBox;
    private double chargePerMile;

    public Courier(int id, String name, double maxDeliveryMiles, boolean hasRefrigeratedBox, double chargePerMile, String startHouInNumber, String endHourInNumber) {
        this.id = id;
        this.name = name;
        this.maxDeliveryMiles = maxDeliveryMiles;
        this.hasRefrigeratedBox = hasRefrigeratedBox;
        this.chargePerMile = chargePerMile;
        this.startHour = LocalTime.parse(startHouInNumber, DateTimeFormatter.ISO_LOCAL_TIME);
        this.endHour = LocalTime.parse(endHourInNumber, DateTimeFormatter.ISO_LOCAL_TIME);;
    }

    public int getId() {return id;}

    public String getName() {
        return name;
    }

    public double getMaxDeliveryMilesMiles() {
        return maxDeliveryMiles;
    }

    public boolean hasRefrigeratedBox() {
        return hasRefrigeratedBox;
    }

    public double getChargePerMile() {
        return chargePerMile;
    }


    public LocalTime getStartHour() {
        return startHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }


    @Override
    public String toString() {
        return "Name: " + this.name + "\n" + "Miles: "+ this.maxDeliveryMiles + "\n" + "Charge per Mile: "+ this.chargePerMile;
    }
}
