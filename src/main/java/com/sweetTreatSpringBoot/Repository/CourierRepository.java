package com.sweetTreatSpringBoot.Repository;

import com.sweetTreatSpringBoot.entity.Courier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface CourierRepository extends MongoRepository<Courier, String> {
}
