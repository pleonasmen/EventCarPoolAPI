package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/user")
    public List<User> getMessages() {
        return (List<User>) repository.findAll();
    }

 /*   @GetMapping("/message/{id}")
    public Message getMessages(@PathVariable Long id) {
        return messageRepository.findById(id).get();
    }

    @PostMapping("/message")
    public Message post(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    @PutMapping("/message/{id}")
    public Message put(@PathVariable Long id, @RequestBody Message message) {
        return messageRepository.save(message);
    }

    @DeleteMapping("/message/{id}")
    public void delete(@PathVariable Long id) {
        messageRepository.deleteById(id);
    }

    }*/
}
