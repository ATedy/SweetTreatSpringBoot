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

     public static List<Courier> allCouriers(){
        List<Courier>  couriers =  new ArrayList<>();
        couriers.add(new Courier("1", "Bobby", 5, LocalTime.parse("09:00"),  LocalTime.parse("13:00"), true, 1.75));
        couriers.add( new Courier("2","Martin", 3,  LocalTime.parse("09:00"),  LocalTime.parse("17:00"), false , 1.5));
        couriers.add( new Courier("3","Geoff",5,  LocalTime.parse("10:00"),  LocalTime.parse("17:00"), true , 2.00));
    return couriers;
     }


    public List<Courier> getAll() {
        return allCouriers();
    }

    public Courier getOneCourier(String id){
        return Repository.allCouriers().stream()
                .filter(courier -> courier.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Courier addCourier(Courier courier) {

        Repository.allCouriers().add(courier);
        System.out.println(Repository.allCouriers().size() + "and " + courier);
        return courier;
    }

    public  Courier cheapestCourierSelector(Order order){
        List<Courier> availableCourier = Repository.allCouriers().stream()
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
