package com.example.EventCarPoolAPI;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@IdClass(UserJourneyRequestId.class)
@Table(name = "User_Requests_Seat_In_Journey")
public class UserJourneyRequest {

    @Id
    private Long requestId;
//    @Id
//    private Long journeyId;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="journeyId")
    private Journey journey;
    private String requestStatus;

    UserJourneyRequest() {}

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Long getJourneyId() {
//        return journeyId;
//    }
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
}