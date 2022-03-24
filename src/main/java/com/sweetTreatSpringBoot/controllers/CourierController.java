package com.sweetTreatSpringBoot.controllers;

import com.sweetTreatSpringBoot.entity.Courier;
import com.sweetTreatSpringBoot.entity.Order;
import com.sweetTreatSpringBoot.services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("couriers")
public class CourierController {

    @Autowired
    private CourierService courierService;
//
//    @PostMapping(path = "/couriers")
//    public void addCourier(@RequestBody Courier courier){
//        courierService.addCourier(courier);
//    }

    @RequestMapping("/")
    public List<Courier>getAllCouriers()
    {
        List<Courier> couriers = courierService.getAll();

        return couriers;
    }

    @RequestMapping("couriers/{id}")
    public Courier getOneCourier(@PathVariable("id") String id){
        return courierService.getOneCourier(id);
    }

    @RequestMapping("/cheapest")
    public Courier cheapestCourier(@RequestBody Order order){
        return  courierService.cheapestCourierSelector(order);
    }


}
