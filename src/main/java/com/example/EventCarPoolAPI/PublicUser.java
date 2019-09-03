package com.example.EventCarPoolAPI;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "[User]")
public class PublicUser {

    public static final String ROLE_PREFIX = "ROLE_";

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    @JsonIgnore
    private String password;
    private String gender;
    private String email;
    private LocalDate registrationDate;
    private String phoneNumber;
    private String imageURL;
    private Long favouriteTeamId;
    private String role;

    PublicUser() {}

    PublicUser(String firstName, String lastName, String userName, String password, String gender, String emailAddress, String phoneNumber, Long favouriteTeamId, String role) {
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setPassword(password);
        setGender(gender);
        setEmail(emailAddress);
        setPassword(phoneNumber);
        setRegistrationDate();
        setFavouriteTeamId(favouriteTeamId);
        setRole(role);
    }

    PublicUser(String firstName, String lastName, String userName, String gender, String email, LocalDate registrationDate, String phoneNumber, String imageURL, Long favouriteTeamId, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.registrationDate = registrationDate;
        this.phoneNumber = phoneNumber;
        this.imageURL = imageURL;
        this.favouriteTeamId = favouriteTeamId;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate() {
        this.registrationDate = LocalDate.now();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Long getFavouriteTeamId() {
        return favouriteTeamId;
    }

    public void setFavouriteTeamId(Long favouriteTeamId) {
        this.favouriteTeamId = favouriteTeamId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }


    //    public List<Journey> getRequestedJourneys() {
//        return requestedJourneys;
//    }
//
//    public void setRequestedJourneys(List<Journey> requestedJourneys) {
//        this.requestedJourneys = requestedJourneys;
//    }
}