package com.example.EventCarPoolAPI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JourneyRepository extends CrudRepository<Journey, Long> {

    List<Journey> findByDriverId(Long id);
}
