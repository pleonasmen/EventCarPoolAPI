package com.example.EventCarPoolAPI;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
    UserRepository userRepository;
    @Autowired
    JourneyRepository journeyRepository;
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

    public Post parseJsonPost(String post)throws JSONException {

        ArrayList<String> elementValues = parseAllElements(post);
        System.out.println(elementValues);

        // assigning values

        Long userId = Long.valueOf(elementValues.get(0));
        String textField = elementValues.get(1);
        Long journeyId = Long.valueOf(elementValues.get(2));

        User user = userRepository.findById(userId).get();
        Journey journey = journeyRepository.findById(journeyId).get();

//        String firstName = elementValues.get(0);
//        String lastName = elementValues.get(1);
//        String username = elementValues.get(2);
//        String password = encoder.encode(elementValues.get(3));
//        String gender = elementValues.get(4);
//        String email = elementValues.get(5);
//        String phoneNumber =  elementValues.get(6);
//        Long favouriteTeamId = Long.valueOf(elementValues.get(7));
//        String role = "USER";
        return new Post(textField, user, journey);
    }

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