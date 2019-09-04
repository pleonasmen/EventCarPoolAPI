package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JourneyController {

    @Autowired
    JourneyRepository repository;

    @Autowired
    JourneyPreviewRepository previewRepository;

    @Autowired
    ParseJsonJohan parser;

    @GetMapping("/journey")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Journey> getJourneys(){return (List<Journey>)repository.findAll();}


    @GetMapping("/journey/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Journey getJourneyById(@PathVariable Long id) {
        return repository.findById(id).get();
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

    @PostMapping(value="/journey", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public Journey createJourney(@RequestBody String journey) {
        return repository.save(parser.parseJson(journey));

    }

    @GetMapping("/driverJourneys/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Journey> getJourneysByDriverId(@PathVariable Long id) {
        return (List<Journey>) repository.findByDriverId(id);
    }


}
