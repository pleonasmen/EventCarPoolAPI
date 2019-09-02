package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {


    @Autowired
    PostRepository repository;

    @Autowired
    ParseJsonJohan parser;

    @GetMapping("/post")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Post> getPost(){return (List<Post>)repository.findAll();}

    @GetMapping("/post/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Post getPostById(@PathVariable Long id) {
        return repository.findById(id).get();
    }


    @PostMapping(value="/post", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public Post createPost(@RequestBody String post) {
        return repository.save(parser.parseJsonPost(post));

    }
}
