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


    public Courier(String id, String name, double maxDeliveryMiles, String startHour, String endHour, boolean hasRefrigeratedBox, double chargePerMile) {
        this.id = id;
        this.name = name;
        this.maxDeliveryMiles = maxDeliveryMiles;
        this.startHour = LocalTime.parse(startHour, DateTimeFormatter.ISO_LOCAL_TIME);;
        this.endHour = LocalTime.parse(endHour, DateTimeFormatter.ISO_LOCAL_TIME);;
        this.hasRefrigeratedBox = hasRefrigeratedBox;
        this.chargePerMile = chargePerMile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxDeliveryMiles() {
        return maxDeliveryMiles;
    }

    public void setMaxDeliveryMiles(double maxDeliveryMiles) {
        this.maxDeliveryMiles = maxDeliveryMiles;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }

    public boolean isHasRefrigeratedBox() {
        return hasRefrigeratedBox;
    }

    public void setHasRefrigeratedBox(boolean hasRefrigeratedBox) {
        this.hasRefrigeratedBox = hasRefrigeratedBox;
    }

    public double getChargePerMile() {
        return chargePerMile;
    }

    public void setChargePerMile(double chargePerMile) {
        this.chargePerMile = chargePerMile;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" + "Miles: "+ this.maxDeliveryMiles + "\n" + "Charge per Mile: "+ this.chargePerMile;
    }
}
