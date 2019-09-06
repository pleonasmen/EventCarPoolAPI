package com.example.EventCarPoolAPI;

import com.example.EventCarPoolAPI.userhandling.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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



//        System.out.println(a);

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