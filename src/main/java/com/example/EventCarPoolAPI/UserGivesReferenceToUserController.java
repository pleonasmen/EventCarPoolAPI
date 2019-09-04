package com.example.EventCarPoolAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class UserGivesReferenceToUserController {

    @Autowired
    ParseJsonJohan parser;


    @Autowired
    UserGivesReferenceToUserRepository repository;


    @GetMapping("/reference")
    public List<UserGivesReferenceToUser> getReferences(){
        return (List<UserGivesReferenceToUser>)repository.findAll();
    }
    @PostMapping("/reference")
    @CrossOrigin(origins = "http://localhost:3000")
    public UserGivesReferenceToUser postReference(@RequestBody String reference) {
        System.out.println(reference);
        return repository.save(parser.parseRefJson(reference));
    }
}

