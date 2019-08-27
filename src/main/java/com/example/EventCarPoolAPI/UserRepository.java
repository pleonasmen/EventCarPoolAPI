package com.example.EventCarPoolAPI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUserName(String username);

}
