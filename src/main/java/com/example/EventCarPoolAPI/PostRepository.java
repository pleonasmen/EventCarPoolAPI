package com.example.EventCarPoolAPI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface PostRepository  extends CrudRepository<Post, Long> {


}
