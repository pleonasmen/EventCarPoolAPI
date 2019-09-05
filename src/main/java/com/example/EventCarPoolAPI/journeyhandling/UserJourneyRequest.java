package com.example.EventCarPoolAPI.journeyhandling;

import com.example.EventCarPoolAPI.journeyhandling.Journey;
import com.example.EventCarPoolAPI.userhandling.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
//@IdClass(UserJourneyRequestId.class)
@Table(name = "User_Requests_Seat_In_Journey")
public class UserJourneyRequest {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long requestId;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="journeyId")
    private Journey journey;
    private String requestStatus;
    private String message;


    UserJourneyRequest() {}

    public UserJourneyRequest(User user, Journey journey, String requestStatus, String message) {
        this.user = user;
        this.journey = journey;
        this.requestStatus = requestStatus;
        this.message = message;
    }



//
//    public void setJourneyId(Long journeyId) {
//        this.journeyId = journeyId;
//    }


    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
