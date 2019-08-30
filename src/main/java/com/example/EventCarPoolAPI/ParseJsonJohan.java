package com.example.EventCarPoolAPI;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


@Service
public class ParseJsonJohan {

    @Autowired
    PasswordEncoder encoder;

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


