package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentRepository repository;

    @GetMapping("/comment")
    public List<Comment> getComments(){return (List<Comment>) repository.findAll(); }
}
