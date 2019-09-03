package com.example.EventCarPoolAPI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface PublicUserRepository extends CrudRepository<PublicUser, Long> {

    PublicUser findUserByUserName(String username);

}
