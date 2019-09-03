package com.example.EventCarPoolAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    PublicUserRepository publicUserRepository;


    @Autowired
    ParseJsonJohan parser;


    @Controller
    @RequestMapping("/")
    public class RedirectController {


        @RequestMapping("/redirect")
        public RedirectView localRedirect(Principal principal) {
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:3000");
            return  redirectView;
        }
    }

    @PostMapping("/loginpage")
    @CrossOrigin(origins = "http://localhost:3000")
    public PublicUser getLogin(@RequestBody String loginDetails) {

       return parser.parseLogin(loginDetails);
    }

    @GetMapping("/user")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<User> getUsers(Principal principal) {
        return (List<User>) repository.findAll();
    }

    @GetMapping("/user/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public User getUserById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping(value="/user", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public User createUser(@RequestBody String user) {

        User user2 = parser.parseJsonUser(user);
        System.out.println("hej");
        return repository.save(user2);
    }

    @PutMapping("/user/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public User editUser(@PathVariable Long id, @RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping(value="/addfriend", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public User addFriend(@RequestBody String friendInfo) {

        User user2 = parser.parseJsonUser(friendInfo);
        return repository.save(user2);
    }

}


