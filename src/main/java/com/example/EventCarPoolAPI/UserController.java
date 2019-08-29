package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/user")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<User> getUsers() {
        return (List<User>) repository.findAll();
    }

    @GetMapping("/user/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public User getUserById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/user")
    @CrossOrigin(origins = "http://localhost:3000")
    public User createUser(@RequestBody String user, @RequestHeader Map<String, String> headers) {

        return new User();
    }


    @PutMapping("/user/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public User editUser(@PathVariable Long id, @RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

}


