package com.sweetTreatSpringBoot.controllers;

import com.sweetTreatSpringBoot.entity.Courier;
import com.sweetTreatSpringBoot.entity.Order;
import com.sweetTreatSpringBoot.services.CourierService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sweetTreats")
public class CourierController {

    @Autowired
    private CourierService courierService;


    @PostMapping(path = "couriers/add")
    public void addCourier(@RequestBody Courier courier){
        courierService.addCourier(courier);
    }

    @GetMapping("/")
    public String homePage()
    {
        return "Welcome To Our SHop";
    }

    @GetMapping("/couriers")
    public List<Courier>getAllCouriers()
    {
        List<Courier> couriers = courierService.getAll();

        return couriers;
    }

    @GetMapping("/couriers/{id}")
    public Courier getOneCourier(@PathVariable("id") String id){
        return courierService.getOneCourier(id);
    }

    @GetMapping("/couriers/cheapest")
    public Courier cheapestCourier(@RequestBody Order order){
        return  courierService.cheapestCourierSelector(order);
    }

    @GetMapping("/availableCourier")
    public Courier availableCourier(@RequestBody Order order){
        return  courierService.availableCourier(order);
    }


}
