package com.example.EventCarPoolAPI;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
@Service
public class ParseJsonJohan {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JourneyRepository journeyRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    PublicUserRepository publicUserRepository;
    @Autowired
    UserJourneyRequestRepository requestRepository;

    public Journey parseJson(String journey)throws JSONException {
        ArrayList<String> elementValues = parseAllElements(journey);
        // assigning values
        String driverId = elementValues.get(0);
        Long matchId = Long.parseLong((elementValues.get(1)));
        Integer seats = Integer.parseInt((elementValues.get(2)));
        String fromCity = elementValues.get(3);
        String toCity = elementValues.get(4);
        LocalDate startTime = LocalDate.parse(elementValues.get(5));
        LocalDate createdDate = LocalDate.now();
        Integer contributionPerHead = Integer.parseInt(elementValues.get(6));
        String tripType = elementValues.get(7);
        return new Journey(Long.valueOf(driverId), matchId, seats, fromCity, toCity, startTime, createdDate, contributionPerHead, tripType );
    }
    public User parseJsonUser(String user)throws JSONException {
        ArrayList<String> elementValues = parseAllElements(user);
        // assigning values
        String firstName = elementValues.get(0);
        String lastName = elementValues.get(1);
        String username = elementValues.get(2);
        String password = encoder.encode(elementValues.get(3));
        String gender = elementValues.get(4);
        String email = elementValues.get(5);
        String phoneNumber =  elementValues.get(6);
        Long favouriteTeamId = Long.valueOf(elementValues.get(7));
        String role = "USER";
        return new User(firstName, lastName, username, password, gender, email, phoneNumber, favouriteTeamId, role);
    }

    public Post parseJsonPost(String post)throws JSONException {
        ArrayList<String> elementValues = parseAllElements(post);
        System.out.println(elementValues);
        // assigning values
        Long userId = Long.valueOf(elementValues.get(0));
        String textField = elementValues.get(1);
        Long journeyId = Long.valueOf(elementValues.get(2));
        User user = userRepository.findById(userId).get();
        Journey journey = journeyRepository.findById(journeyId).get();
        return new Post(textField, user, journey);
    }


    public UserGivesReferenceToUser parseRefJson(String reference)throws JSONException {
        ArrayList<String> elementValues = parseAllElements(reference);
        for (String s:elementValues
        ) {
            System.out.println(s);
        }
        String referenceType = elementValues.get(2);
        Long giverId = Long.valueOf(elementValues.get(0));
        Long receiverId = Long.parseLong((elementValues.get(1)));
        User user = userRepository.findById(receiverId).get();
        String textField = (elementValues.get(6));
        LocalDate time = LocalDate.now();
        String giverRole = elementValues.get(4);
        String receiverRole = elementValues.get(5);
        return new UserGivesReferenceToUser(giverId,referenceType, time, giverRole, receiverRole, textField, user);
    }


    public Comment parseJsonComment(String comment)throws JSONException {
        ArrayList<String> elementValues = parseAllElements(comment);

        String textField = elementValues.get(0);
        Long userCommentingId = Long.valueOf(elementValues.get(1));
        Long postId = Long.valueOf(elementValues.get(2));
        return new Comment(textField, userRepository.findById(userCommentingId).get(),postRepository.findById(postId).get());
    }

    public Like parseJsonLike(String like)throws JSONException {
        ArrayList<String> elementValues = parseAllElements(like);

        Long userCommentingId = Long.valueOf(elementValues.get(0));
        Long postId = Long.valueOf(elementValues.get(1));
        return new Like(userRepository.findById(userCommentingId).get(),postRepository.findById(postId).get());
    }

    public User parseJsonFriendInfo(String friendInfo)throws JSONException {
        ArrayList<String> elementValues = parseAllElements(friendInfo);
        for (String s:elementValues
        ) {
            System.out.println(s);
        }
//        String referenceType = elementValues.get(2);
//        Long giverId = Long.valueOf(elementValues.get(0));
//        Long receiverId = Long.parseLong((elementValues.get(1)));
//        User user = userRepository.findById(receiverId).get();
//        String textField = (elementValues.get(6));
//        LocalDate time = LocalDate.now();
//        String giverRole = elementValues.get(4);
//        String receiverRole = elementValues.get(5);
//        return new UserGivesReferenceToUser(giverId,referenceType, time, giverRole, receiverRole, textField, user);
        return new User();
    }

    public UserJourneyRequest parseJsonRequest(String request) throws JSONException {
        ArrayList<String> elementValues = parseAllElements(request);
        UserJourneyRequest getRequest = requestRepository.findById(Long.valueOf(elementValues.get(0))).get();

        if(request.toLowerCase().indexOf("denied") != -1){
            getRequest.setRequestStatus("denied");
        }else{
            getRequest.setRequestStatus("accepted");
        }


        System.out.println(getRequest.getRequestStatus() + " request Status !!!!!!");
        return getRequest;
    }

    public PublicUser parseLogin(String loginDetails)throws JSONException {
        ArrayList<String> elementValues = parseAllElements(loginDetails);

        PublicUser user = publicUserRepository.findUserByUserName(elementValues.get(0));

        if (user.getPassword().equals(elementValues.get(1))) {
            return user;
        } else {
            return null;
        }
    }

    public ArrayList<String> parseAllElements(String stringToParse)throws JSONException {
        ArrayList<String> elementValues = new ArrayList<>();
        stringToParse = stringToParse.replace("\"", "");
        stringToParse = stringToParse.replace("}", "");
        String [] keyValuePairs = stringToParse.split(",");
        for (int i = 0; i < keyValuePairs.length; i++) {
            String[] values = keyValuePairs[i].split(":");
            elementValues.add(values[1]);
            System.out.println("Element" + i + " : " + elementValues.get(i));
        }
        return elementValues;
    }
}