package com.example.EventCarPoolAPI.journeyhandling;


import com.example.EventCarPoolAPI.userhandling.User;
import com.example.EventCarPoolAPI.posthandling.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Journey")
public class JourneyPreview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "journeyId")
    private Long journeyId;
    @ManyToOne
    @JoinColumn(name="driverId")
    private User driver;
    private Long matchId;
    private Integer seats;

    private String fromCity;
    @JsonIgnore
    private String toCity;
    private LocalDate startTime;
    private LocalDate CreatedDate;
    @JsonIgnore
    private Integer contributionPerHead;
    private String tripType;
    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "journey")
    private List<Post> posts;
    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "journey")
    private List<UserJourneyRequest> requests;
    @Transient
    private Integer vacantSeats = 2;
//    @JsonManagedReference
//    @ManyToMany
//    @JoinTable(name = "User_Requests_Seat_In_Journey",
//            joinColumns = @JoinColumn(name = "journeyId"),
//            inverseJoinColumns = @JoinColumn(name = "userId"))
//    @Where (clause = "requestStatus = 'accepted'")
//    private List<User> usersRequesting;


    public JourneyPreview() { }

    public JourneyPreview(Long journeyPreviewId, Long matchId, Integer seats, String fromCity, String toCity, LocalDate startTime, LocalDate createdDate, Integer contributionPerHead, String tripType) {
        this.journeyId = journeyPreviewId;
        this.matchId = matchId;
        this.seats = seats;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.vacantSeats = 4;
        this.startTime = startTime;
        CreatedDate = createdDate;
        this.contributionPerHead = contributionPerHead;
        this.tripType = tripType;
    }


    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Long getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(Long journeyId) {
        this.journeyId = journeyId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getVacantSeats() {
        return vacantSeats;
    }

    public void setVacantSeats(Integer vacantSeats) {
        this.vacantSeats = 3;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        CreatedDate = createdDate;
    }

    public Integer getContributionPerHead() {
        return contributionPerHead;
    }

    public void setContributionPerHead(Integer contributionPerHead) {
        this.contributionPerHead = contributionPerHead;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }




}