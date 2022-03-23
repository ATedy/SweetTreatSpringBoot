package com.sweetTreatSpringBoot.couriers;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CourierService{
    public List<Courier> getAll() {
        List<Courier> couriers =  Arrays.asList(
                new Courier("Bobby", 5, true, 1.75, "09:00" , "13:00" ),
                new Courier("Martin", 3, false, 1.5, "09:00" , "17:00"),
                new Courier("Geoff", 5, true, 2.00,"10:00" , "16:00" )
        );
        return couriers;
    }
}
