package com.sweetTreatSpringBoot.couriers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourierController {

    @Autowired
    private CourierService courierService;

    @GetMapping(value = "/couriers")
    public List<Courier>getCourier()
    {
        List<Courier> couriers = courierService.getAll();

        return couriers;
    }
}
