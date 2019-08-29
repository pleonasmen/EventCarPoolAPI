package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JourneyController {

    @Autowired
    JourneyRepository repository;

    @Autowired
    JourneyPreviewRepository previewRepository;

    @GetMapping("/journey")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Journey> getJourneys(){return (List<Journey>)repository.findAll();}

    @GetMapping("/journey/{id}")
    public Journey getJourneyById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/journey")
    public Journey createUser(@RequestBody Journey journey) {
        return repository.save(journey);
    }

    @PutMapping("/journey/{id}")
    public Journey editJourney(@PathVariable Long id, @RequestBody Journey journey) {
        return repository.save(journey);
    }

    @DeleteMapping("/journey/{id}")
    public void deleteJourney(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/journeypreview")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<JourneyPreview> getPreviewJourneys(){return (List<JourneyPreview>)previewRepository.findAll();}


}

