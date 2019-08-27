package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserGivesReferenceToUserController {
    /*
    Fungerar ej pga many-to-one mappning
     */

    @Autowired
    UserGivesReferenceToUserRepository repository;

    @GetMapping("/reference")
    public List<UserGivesReferenceToUser> getReferences(){
        return (List<UserGivesReferenceToUser>)repository.findAll();
    }
}
