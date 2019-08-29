package com.example.EventCarPoolAPI;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service
public class ParseJsonJohan {

    @Autowired
    UserRepository repository;


    public Journey parseJson(String journey)throws JSONException {
        System.out.println(journey);
        String journey2 = journey.replace("\"", "");
        String journey3 = journey2.replace(",", " ");
        String [] letters = journey2.split(",");
        String [] letters2 = journey3.split(":");
        System.out.println("!!!!!! ELEMENTS !!!!!!!");
        String[] element = {"","","","","","","","","","","","","","","","","","",""};
        for (int i = 0; i < letters.length-1; i++) {
            //System.out.println(letters[i]);
            String[] output = letters[i].split(":");
            element[i]=output[1];
            System.out.println("Element" + i + " : " + element[i]);
        }
        String userId = element[0];
        String name = element[1];
        String surname = element[2];
        String userName = element[3];
        String gender = element[4];
        String email = element[5];
        LocalDate registrationDate = LocalDate.parse(element[6]);
        String phoneNumber = element[7];
        String imageURL = element[8];
        Long favouriteTeamId = Long.parseLong(element[9]);
        String role = element[10];
        Long matchId = Long.parseLong((element[11]));
        Integer seats = Integer.parseInt((element[12]));
        String fromCity = element[13];
        String toCity = element[14];
        LocalDate startTime = LocalDate.parse(element[15]);
        LocalDate createdDate = LocalDate.parse(element[16]);
        Integer contributionPerHead = Integer.parseInt(element[17]);
        String tripType = element[18];

        return new Journey(null, Long.valueOf(userId), matchId, seats, fromCity, toCity, startTime, createdDate, contributionPerHead, tripType );



    }
}


