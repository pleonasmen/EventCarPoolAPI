package com.example.EventCarPoolAPI;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Journey")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "journeyId")
    private Long journeyId;
    private Long driverId;
    private Long matchId;
    private Integer seats;
    private String fromCity;
    private String toCity;
    private LocalDate startTime;
    private LocalDate createdDate;
    private Integer contributionPerHead;
    private String tripType;
    @JsonManagedReference
    @OneToMany(mappedBy = "journey")
    private List<Post> posts;
    @JsonManagedReference
    @OneToMany(mappedBy = "journey")
    private List<UserJourneyRequest> requests;



    public Journey() { }

    public Journey(Long driverId, Long matchId, Integer seats, String fromCity, String toCity, LocalDate startTime, LocalDate createdDate, Integer contributionPerHead, String tripType) {
        this.matchId = matchId;
        this.driverId = driverId;
        this.seats = seats;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.startTime = startTime;
        this.createdDate = createdDate;
        this.contributionPerHead = contributionPerHead;
        this.tripType = tripType;
    }


    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
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
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }




    public List<UserJourneyRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<UserJourneyRequest> requests) {
        this.requests = requests;
    }
}