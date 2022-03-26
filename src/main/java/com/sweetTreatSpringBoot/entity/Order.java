package com.sweetTreatSpringBoot.entity;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private LocalTime orderHour;
    private double customerDistance;
    private boolean IsRefrigerated;

//    public Order() {
//    }

    public Order(String orderHour, double customerDistance, boolean isRefrigerated) {
        this.orderHour = LocalTime.parse(orderHour, DateTimeFormatter.ISO_LOCAL_TIME);
        this.customerDistance = customerDistance;
        this.IsRefrigerated = isRefrigerated;
    }

    public LocalTime getOrderHour() {
        return orderHour;
    }

    public double getCustomerDistance() {
        return customerDistance;
    }

    public boolean isRefrigerated() {
        return IsRefrigerated;
    }

    public void setOrderHour(LocalTime orderHour) {
        this.orderHour = orderHour;
    }

    public void setCustomerDistance(double customerDistance) {
        this.customerDistance = customerDistance;
    }

    public void setRefrigerated(boolean refrigerated) {
        this.IsRefrigerated = refrigerated;
    }
}

