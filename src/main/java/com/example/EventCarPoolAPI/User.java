package com.example.EventCarPoolAPI;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "[User]")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String gender;
    private String email;
    private LocalDate registrationDate;
    private String phoneNumber;
    private String imageURL;
    private Long favouriteTeamId;

    User() {}

    User(String firstName, String lastName, String userName, String password, String gender, String emailAddress, String phonenumber, String imageURL, Long favouriteTeamId) {
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setPassword(password);
        setGender(gender);
        setEmail(emailAddress);
        setRegistrationDate();
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
}
