package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JourneyController {

    @Autowired
    JourneyRepository repository;

    @GetMapping("/journey")
    public List<Journey> getJourneys(){return (List<Journey>)repository.findAll();}
}
