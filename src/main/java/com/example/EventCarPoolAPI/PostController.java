package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {


    @Autowired
    PostRepository repository;

    @GetMapping("/post")
    public List<Post> getJourneys(){return (List<Post>)repository.findAll();}
}
