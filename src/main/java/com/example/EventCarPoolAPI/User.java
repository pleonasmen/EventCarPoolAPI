package com.example.EventCarPoolAPI;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "[User]")
public class User {

    public static final String ROLE_PREFIX = "ROLE_";

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
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
    @JsonBackReference
    @OneToMany(mappedBy = "userPosting")
    private List<Post> posts;
    @JsonBackReference
    @OneToMany(mappedBy = "userCommenting")
    private List<Comment> comments;
    @JsonBackReference
    @OneToMany(mappedBy = "userLiking")
    private List<Like> likes;
    @JsonBackReference
    @OneToMany(mappedBy = "driver")
    private List<Journey> journeysAsDriver;
//    @JsonBackReference
//    @ManyToMany
//    @JoinTable(name = "User_Requests_Seat_In_Journey",
//            joinColumns = @JoinColumn(name = "userId"),
//            inverseJoinColumns = @JoinColumn(name = "journeyId"))
//    @Where (clause = "requestStatus = 'waiting'")
//    private List<Journey> requestedJourneys;


    User() {}

    User(String firstName, String lastName, String userName, String password, String gender, String emailAddress, String phoneNumber, String imageURL, Long favouriteTeamId, String role) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

//    public List<Journey> getRequestedJourneys() {
//        return requestedJourneys;
//    }
//
//    public void setRequestedJourneys(List<Journey> requestedJourneys) {
//        this.requestedJourneys = requestedJourneys;
//    }
}
