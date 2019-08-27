package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/user")
    public List<User> getUsers() {
        return (List<User>) repository.findAll();
    }

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
    }

}