package com.example.EventCarPoolAPI.posthandling;

import com.example.EventCarPoolAPI.service.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LikeController {

    @Autowired
    LikeRepository repository;

    @Autowired
    JsonParser parser;

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
