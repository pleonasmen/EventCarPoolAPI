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
import javax.servlet.http.HttpSession;
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

    @Autowired
    HttpSession session;


    @Controller
    @RequestMapping("/")
    public class RedirectController {

        @RequestMapping("/redirect")
        public RedirectView localRedirect() {
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:3000");
            return  redirectView;
        }
    }

    @PostMapping("/loginpage")
    @CrossOrigin(origins = "http://localhost:3000")
    public PublicUser getLogin( @RequestBody String loginDetails) {
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

    @GetMapping("/user/rating/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Long getUserRatingById(@PathVariable Long id) {

        Double posCount = 0.0;

        User user = repository.findById(id).get();
        List<UserGivesReferenceToUser> references = user.getReferences();

        if(references.size() > 0) {
            for (UserGivesReferenceToUser reference : references) {
                System.out.println(reference.getReferenceType());
                if (reference.getReferenceType().equals("Positive")) {
                    posCount++;
                    System.out.println("++++");
                }
            }

            Long rating = Math.round((posCount / references.size()) * 100);

            return rating;

        } else {
            return -1L;
        }
        }

}


