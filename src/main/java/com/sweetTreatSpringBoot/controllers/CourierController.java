package com.sweetTreatSpringBoot.controllers;

import com.sweetTreatSpringBoot.entity.Courier;
import com.sweetTreatSpringBoot.entity.Order;
import com.sweetTreatSpringBoot.exceptionHandling.CourierErrorResponse;
import com.sweetTreatSpringBoot.exceptionHandling.CourierNotFoundException;
import com.sweetTreatSpringBoot.services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/sweetTreats")
public class CourierController {

    @Autowired
    private CourierService courierService;

    // new Courier route
    @PostMapping(path = "/couriers/newCourier")
    public ResponseEntity<?> addCourier(@RequestBody Courier courier) {
        courierService.addCourier(courier);
        return new ResponseEntity<>("New Courier Added", HttpStatus.OK);
    }

    // home route
    @GetMapping("/")
    public String homePage() {
        return "Welcome To Our Shop";
    }

    // all couriers route
    @GetMapping("/couriers")
    public List<Courier> getAllCouriers() {
        List<Courier> couriers = courierService.getAll();

        return couriers;
    }

    //     single courier route
    @GetMapping("/couriers/{id}")
    public ResponseEntity<?> getOneCourier(@PathVariable("id") String id) {
        return courierService.getOneCourier(id);

    }

    // Courier update Route
    @PutMapping("/couriers/{id}")
    public ResponseEntity<Courier> updateCourier(@PathVariable("id") String id, @RequestBody Courier courier) {
        return courierService.updateCourier(id, courier);
    }


    // deleting a courier route
    // add for id is not correct
    @DeleteMapping("/couriers/{id}")
    public String deleteCourier(@PathVariable("id") String id) {

            courierService.deleteCourier(id);
            return "Courier deleted Successfully";

    }


    // cheapest courier route
    @PostMapping("/couriers/cheapest")
    public ResponseEntity<?> cheapestCourier(@RequestBody Order order) {
        if (courierService.cheapestCourierSelector(order) != null) {
            return new ResponseEntity<Courier>(courierService.cheapestCourierSelector(order), HttpStatus.OK);
        }
        return new ResponseEntity<>("No courier available at this time", HttpStatus.NOT_FOUND);
    }




}
