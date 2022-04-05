package com.sweetTreatSpringBoot.Repository;

import com.sweetTreatSpringBoot.entity.Courier;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourierRepository extends MongoRepository<Courier, String> {
}
