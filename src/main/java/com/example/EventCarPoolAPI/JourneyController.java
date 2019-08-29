package com.example.EventCarPoolAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JourneyController {

    @Autowired
    JourneyRepository repository;

    @Autowired
    ParseJsonJohan parser;

    JourneyPreviewRepository previewRepository;


    @PostMapping(value="/journey", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("/journey")
    @CrossOrigin(origins = "http://localhost:3000")
    public Journey createJourney(@RequestBody String journey) {
        Journey newJourney = parser.parseJson(journey);
        System.out.println("tjena   " + newJourney.getFromCity());
        return repository.save(newJourney);

}

    @GetMapping("/journey/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
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

