package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LikeController {

    @Autowired
    LikeRepository repository;

    @Autowired
    ParseJsonJohan parser;

  @GetMapping("/like")
   public List<Like> getLikes() {
      return (List<Like>) repository.findAll();
    }

    @PostMapping(value="/like", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public Like createLike(@RequestBody String like) {
        return repository.save(parser.parseJsonLike(like));

    }

}
