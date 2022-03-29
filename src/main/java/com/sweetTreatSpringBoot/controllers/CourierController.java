package com.sweetTreatSpringBoot.controllers;
import com.sweetTreatSpringBoot.entity.Courier;
import com.sweetTreatSpringBoot.entity.Order;
import com.sweetTreatSpringBoot.exceptionHandling.CourierErrorResponse;
import com.sweetTreatSpringBoot.exceptionHandling.CourierNotFoundException;
import com.sweetTreatSpringBoot.services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sweetTreats")
public class CourierController {

    @Autowired
    private CourierService courierService;


    @PostMapping(path = "/couriers/newCourier")
    public void addCourier(@RequestBody Courier courier){
        courierService.addCourier(courier);
    }

    // home route
    @GetMapping("/")
    public String homePage()
    {
        return "Welcome To Our Shop";
    }

    // all couriers route
    @GetMapping("/couriers")
    public List<Courier>getAllCouriers()
    {
        List<Courier> couriers = courierService.getAll();

        return couriers;
    }

    // single courier route
    @GetMapping("/couriers/{id}")
    public Courier getOneCourier(@PathVariable("id") String id){

        //  checks id against courier list size
        if((Integer.parseInt(id) >= courierService.getAll().size()) || Integer.parseInt(id) < 0){
            throw new CourierNotFoundException("Courier with id " + id + " not found. " +
                    "Please enter numbers between 0 and " + courierService.getAll().size());
        }
        return courierService.getOneCourier(id);
    }

    // cheapest route
    @GetMapping("/couriers/cheapest")
    public Courier cheapestCourier(@RequestBody Order order){
        return  courierService.cheapestCourierSelector(order);
    }


    // exception handler method for courier
    @ExceptionHandler
    public ResponseEntity<CourierErrorResponse> handleException(CourierNotFoundException exc){
        CourierErrorResponse error = new CourierErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
