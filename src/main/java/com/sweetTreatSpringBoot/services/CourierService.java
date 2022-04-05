package com.sweetTreatSpringBoot.services;

import com.sweetTreatSpringBoot.Repository.CourierRepository;
import com.sweetTreatSpringBoot.Repository.Repository;
import com.sweetTreatSpringBoot.entity.Courier;
import com.sweetTreatSpringBoot.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourierService{
    CourierRepository courierRepository;

    public List<Courier> getAll() {
        return courierRepository.findAll();
    }

    public ResponseEntity<Courier> getOneCourier(@PathVariable("id") String id) {
        Optional<Courier> courierData = courierRepository.findById(id);
        if (courierData.isPresent()) {
            return new ResponseEntity<>(courierData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    public ResponseEntity<Courier> addCourier(Courier courier) {

        try {
            Courier _courier = courierRepository.save(new Courier(courier.getName(), courier.getMaxDeliveryMiles(), courier.getStartHour(),
                    courier.getEndHour(), courier.isHasRefrigeratedBox(), courier.getChargePerMile()));
            return new ResponseEntity<>(courier, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//
//    public  Courier cheapestCourierSelector(Order order){
//        List<Courier> availableCourier = Repository.getCouriers().stream()
//                .filter(courier -> order.getOrderHour().isAfter(courier.getStartHour()) &&
//                        order.getOrderHour().isBefore(courier.getEndHour()))
//                .filter(c -> c.getMaxDeliveryMiles() >= order.getCustomerDistance())
//                .filter(c1 -> c1.isHasRefrigeratedBox() == order.isIsRefrigerated())
//                .collect(Collectors.toList());
//
//        if(!availableCourier.isEmpty()){
//            Comparator<Courier> comparator = Comparator.comparing(courier -> courier.getChargePerMile() );
//            Courier cheapestCourier = availableCourier.stream().min(comparator).get();
//
//            return  cheapestCourier;
//
//        }
//            return null;
//
//    }

}
