package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentRepository repository;

    @Autowired
    ParseJsonJohan parser;

    @GetMapping("/comment")
    public List<Comment> getComments(){return (List<Comment>) repository.findAll(); }

    @PostMapping(value="/comment", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public Comment createComment(@RequestBody String comment) {
        return repository.save(parser.parseJsonComment(comment));

    }
}
