package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class LikeController {

    @Autowired
    LikeRepository repository;

    @GetMapping("/like")
    public List<Like> getLikes() {
        return (List<Like>) repository.findAll();
    }

}
