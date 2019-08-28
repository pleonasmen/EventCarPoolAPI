package com.example.EventCarPoolAPI;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Post")
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "postId")
    private Long postId;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="user_Id")
    private User userPosting;
    private String textField;
    private LocalDate time;
    @JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    @JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<Like> likes;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="journeyId")
    private Journey journey;




    public Post() {
    }

    public Post(Long postId, String textField, LocalDate time) {
        this.postId = postId;
        this.textField = textField;
        this.time = time;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public User getUserPosting() {
        return userPosting;
    }

    public void setUserPosting(User userPosting) {
        this.userPosting = userPosting;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
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
}
