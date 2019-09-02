package com.example.EventCarPoolAPI;


        import com.fasterxml.jackson.annotation.JsonBackReference;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonManagedReference;
        import com.fasterxml.jackson.annotation.JsonSetter;

        import javax.persistence.*;
        import java.time.LocalDate;
        import java.util.List;

@Entity
@Table(name = "[User]")
public class UserPreview {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String gender;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private LocalDate registrationDate;
    @JsonIgnore
    private String phoneNumber;
    @JsonIgnore
    private String imageURL;
    @JsonIgnore
    private Long favouriteTeamId;
    @JsonIgnore
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
    @JsonManagedReference
    @OneToMany(mappedBy = "userReceiving")
    private List<UserGivesReferenceToUser> references;
    @JsonManagedReference
    @OneToMany(mappedBy = "friend1")
    private List<UserHasFriends> userFriendList1;
    @JsonManagedReference
    @OneToMany(mappedBy = "friend2")
    private List<UserHasFriends> userFriendList2;
    @JsonBackReference
    @OneToMany(mappedBy = "actionUserId")
    private List<UserHasFriends> friendshipActionTaker;

//    @JsonBackReference
//    @ManyToMany
//    @JoinTable(name = "User_Requests_Seat_In_Journey",
//            joinColumns = @JoinColumn(name = "userId"),
//            inverseJoinColumns = @JoinColumn(name = "journeyId"))
//    @Where (clause = "requestStatus = 'waiting'")
//    private List<Journey> requestedJourneys;

    UserPreview() {}

    UserPreview(String firstName, String lastName, String userName, String password, String gender, String emailAddress, String phoneNumber, Long favouriteTeamId, String role) {
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

    UserPreview(String firstName, String lastName, String userName, String gender, String email, LocalDate registrationDate, String phoneNumber, String imageURL, Long favouriteTeamId, String role) {
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

    public List<UserHasFriends> getUserFriendList1() {
        return userFriendList1;
    }

    public void setUserFriendList1(List<UserHasFriends> userFriendList1) {
        this.userFriendList1 = userFriendList1;
    }

    public List<UserHasFriends> getUserFriendList2() {
        return userFriendList2;
    }

    public void setUserFriendList2(List<UserHasFriends> userFriendList2) {
        this.userFriendList2 = userFriendList2;
    }

    //    public List<Journey> getRequestedJourneys() {
//        return requestedJourneys;
//    }
//
//    public void setRequestedJourneys(List<Journey> requestedJourneys) {
//        this.requestedJourneys = requestedJourneys;
//    }
}