package com.sweetTreatSpringBoot.services;

import com.sweetTreatSpringBoot.Repository.Repository;
import com.sweetTreatSpringBoot.entity.Courier;
import com.sweetTreatSpringBoot.entity.Order;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourierService{
    public List<Courier> getAll() {
        return Repository.getCouriers();
    }

    public Courier getOneCourier(String id){
        return Repository.getCouriers().stream()
                .filter(courier -> courier.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Courier addCourier(Courier courier) {

        Repository.getCouriers().add(courier);
        return courier;
    }

    public  Courier cheapestCourierSelector(Order order){
        List<Courier> availableCourier = Repository.getCouriers().stream()
                .filter(courier -> order.getOrderHour().isAfter(courier.getStartHour()) &&
                        order.getOrderHour().isBefore(courier.getEndHour()))
                .filter(c -> c.getMaxDeliveryMiles() >= order.getCustomerDistance())
                .filter(c1 -> c1.isHasRefrigeratedBox() == order.isIsRefrigerated())
                .collect(Collectors.toList());

        if(!availableCourier.isEmpty()){
            Comparator<Courier> comparator = Comparator.comparing(courier -> courier.getChargePerMile() );
            Courier cheapestCourier = availableCourier.stream().min(comparator).get();

            return  cheapestCourier;

        }else{
            System.out.println("not found");
            return null;
        }

    }

}
