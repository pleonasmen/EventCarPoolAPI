package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserJourneyRequestController {

    @Autowired
    UserJourneyRequestRepository repository;

    @Autowired
    JourneyRepository journeyRepository;

    @Autowired
    ParseJsonJohan parser;


    @GetMapping("/userrequest")
    public List<UserJourneyRequest> getUsers() {
        return (List<UserJourneyRequest>) repository.findAll();
    }


    @GetMapping("/userrequest/{id}")
    public UserJourneyRequest getUsersById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping(value="/createRequest", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public UserJourneyRequest createRequest(@RequestBody String journeyRequest) {
        return repository.save(parser.parseJsonRequest(journeyRequest));

    }

    @GetMapping("/userJourneyRequest/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<UserJourneyRequest> getUsers(@PathVariable Long id) {
        List<Journey> journeys = journeyRepository.findByDriverId(id);
        List<UserJourneyRequest> requests = new ArrayList<>();

        for(Journey journey : journeys) {
            for(UserJourneyRequest request : journey.getRequests()) {
                if(request.getRequestStatus().equals("waiting")) {
                    requests.add(request);
                }
            }
        }
        return requests;
    }



/*
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("/user/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }*/

}
