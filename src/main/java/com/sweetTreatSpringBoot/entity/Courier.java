package com.sweetTreatSpringBoot.entity;

import org.hibernate.annotations.Generated;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Courier {
    private  String id;
    private  String name;
    private double maxDeliveryMiles;
    private LocalTime startHour;
    private LocalTime endHour;
    private boolean hasRefrigeratedBox;
    private double chargePerMile;

    public Courier() {
    }

    public Courier(String id, String name, double maxDeliveryMiles, boolean hasRefrigeratedBox, double chargePerMile, String startHouInNumber, String endHourInNumber) {
        this.id = id;
        this.name = name;
        this.maxDeliveryMiles = maxDeliveryMiles;
        this.hasRefrigeratedBox = hasRefrigeratedBox;
        this.chargePerMile = chargePerMile;
        this.startHour = LocalTime.parse(startHouInNumber, DateTimeFormatter.ISO_LOCAL_TIME);
        this.endHour = LocalTime.parse(endHourInNumber, DateTimeFormatter.ISO_LOCAL_TIME);;
    }

    public String getId() {return id;}

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


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxDeliveryMiles(double maxDeliveryMiles) {
        this.maxDeliveryMiles = maxDeliveryMiles;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }

    public void setHasRefrigeratedBox(boolean hasRefrigeratedBox) {
        this.hasRefrigeratedBox = hasRefrigeratedBox;
    }

    public void setChargePerMile(double chargePerMile) {
        this.chargePerMile = chargePerMile;
    }



    @Override
    public String toString() {
        return "Name: " + this.name + "\n" + "Miles: "+ this.maxDeliveryMiles + "\n" + "Charge per Mile: "+ this.chargePerMile;
    }
}
