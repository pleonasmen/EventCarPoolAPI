package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarPoolCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public CarPoolCommandLineRunner(UserRepository repository, PasswordEncoder encoder) {
        this.userRepository = repository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {


//        userRepository.save(user);
//
//        user = new SiteUser("Harry", encoder.encode("123"));
//        List<Role> userRole = new ArrayList<>();
//        userRole.add(new Role("USER"));
//        user.setRoles(roles);
//        userRepository.save(user);

   /*     user = new SiteUser("Kalle", encoder.encode("123"));
        userRole = new ArrayList<>();
        userRole.add(new Role("USER"));
        user.setRoles(roles);
        userRepository.save(user);
*/
        }
}