package com.sweetTreatSpringBoot.Repository;

import com.sweetTreatSpringBoot.entity.Courier;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<Courier> allCouriers(){
       List<Courier> couriers =  new ArrayList<>();
        couriers.add(new Courier("1", "Bobby", 5, "09:00", "13:00", true, 1.75));
        couriers.add( new Courier("2","Martin", 3, "09:00", "17:00", false , 1.5));
        couriers.add( new Courier("3","Geoff",5, "10:00", "17:00", true , 2.00));

    return couriers;
    }
}
