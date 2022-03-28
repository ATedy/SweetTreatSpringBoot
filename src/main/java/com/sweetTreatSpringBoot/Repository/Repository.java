package com.sweetTreatSpringBoot.Repository;

import com.sweetTreatSpringBoot.entity.Courier;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<Courier> allCouriers(){
       List<Courier> couriers =  new ArrayList<>();
        couriers.add(new Courier("1", "Bobby", 5, LocalTime.parse("09:00"),  LocalTime.parse("13:00"), true, 1.75));
        couriers.add( new Courier("2","Martin", 3,  LocalTime.parse("09:00"),  LocalTime.parse("17:00"), false , 1.5));
        couriers.add( new Courier("3","Geoff",5,  LocalTime.parse("10:00"),  LocalTime.parse("17:00"), true , 2.00));

    return couriers;
    }
}
