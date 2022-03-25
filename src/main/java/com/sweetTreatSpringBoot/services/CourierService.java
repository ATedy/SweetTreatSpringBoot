package com.sweetTreatSpringBoot.services;

import com.sweetTreatSpringBoot.entity.Courier;
import com.sweetTreatSpringBoot.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourierService{
    private static List<Courier> couriers =  new ArrayList<>();
    static {
        couriers.add(new Courier("1", "Bobby", 5, "09:00", "13:00", true, 1.75));
        couriers.add( new Courier("2","Martin", 3, "09:00", "17:00", false , 1.5));
        couriers.add( new Courier("3","Geoff",5, "10:00", "17:00", true , 2.00));
    }

    public List<Courier> getAll() {
        return couriers;
    }

    public Courier getOneCourier(String id){
        return couriers.stream()
                .filter(courier -> courier.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addCourier(Courier courier) {
        couriers.add(courier);
    }

    public  Courier cheapestCourierSelector(Order order){
        List<Courier> availableCourier = couriers.stream()
                .filter(courier -> order.getOrderHour().isAfter(courier.getStartHour()) &&
                        order.getOrderHour().isBefore(courier.getEndHour()))
                .filter(c -> c.getMaxDeliveryMiles() >= order.getCustomerDistance())
                .filter(c1 -> c1.hasRefrigeratedBox() == order.isRefrigerated())
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
