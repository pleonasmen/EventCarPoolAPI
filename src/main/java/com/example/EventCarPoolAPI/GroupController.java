package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Table;
import java.util.List;

@RestController
@Table (name = "[Group]")
public class GroupController {

    @Autowired
    GroupRepository repository;

    @GetMapping("/group")
    public List<Group> getMessages() {
        return (List<Group>) repository.findAll();
    }

}
