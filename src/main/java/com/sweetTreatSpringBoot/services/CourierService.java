package com.sweetTreatSpringBoot.services;

import com.sweetTreatSpringBoot.Repository.CourierRepository;
import com.sweetTreatSpringBoot.entity.Courier;
import com.sweetTreatSpringBoot.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourierService {
    @Autowired
    CourierRepository courierRepository;

    public List<Courier> getAll() {
        return courierRepository.findAll();
    }


    public ResponseEntity<?> getOneCourier(String id) {
        Optional<Courier> courierData = courierRepository.findById(id);
        if (courierData.isPresent()) {
            return new ResponseEntity<>(courierData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Courier with that Id not found", HttpStatus.NOT_FOUND);
        }

    }

    public void addCourier(Courier courier) {
        courierRepository.insert(courier);
    }


    public ResponseEntity<Courier> updateCourier(String id, Courier courier) {
        Optional<Courier> courierData = courierRepository.findById(id);
        if (courierData.isPresent()) {
            Courier selectedCourier = courierData.get();
            selectedCourier.setName(courier.getName());
            selectedCourier.setMaxDeliveryMiles(courier.getMaxDeliveryMiles());
            selectedCourier.setStartHour(courier.getStartHour());
            selectedCourier.setEndHour(courier.getEndHour());
            selectedCourier.setHasRefrigeratedBox(courier.isHasRefrigeratedBox());
            selectedCourier.setChargePerMile(courier.getChargePerMile());

            return new ResponseEntity<>(courierRepository.save(selectedCourier), HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public void deleteCourier(String id) {
        courierRepository.deleteById(id);


    }

    public Courier cheapestCourierSelector(Order order) {
        List<Courier> availableCourier = courierRepository.findAll().stream()
                .filter(courier -> order.getOrderHour().isAfter(courier.getStartHour()) &&
                        order.getOrderHour().isBefore(courier.getEndHour()))
                .filter(c -> c.getMaxDeliveryMiles() >= order.getCustomerDistance())
                .filter(c1 -> c1.isHasRefrigeratedBox() == order.isIsRefrigerated())
                .collect(Collectors.toList());

        if (!availableCourier.isEmpty()) {
            Comparator<Courier> comparator = Comparator.comparing(courier -> courier.getChargePerMile());
            Courier cheapestCourier = availableCourier.stream().min(comparator).get();

            return cheapestCourier;

        }
        return null;

    }


}
