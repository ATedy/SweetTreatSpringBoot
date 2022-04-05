package com.sweetTreatSpringBoot.Repository;

import com.sweetTreatSpringBoot.entity.Courier;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface courierRepository extends MongoRepository<Courier, String> {
    List<Courier> findByTitleContaining(String title);
}
