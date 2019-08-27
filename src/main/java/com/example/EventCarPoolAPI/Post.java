package com.example.EventCarPoolAPI;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

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
    private User poster;
    private String textField;
    private LocalDate time;

    public Post() {
    }

    public Post(Long postId, User user, String textField, LocalDate time) {
        this.postId = postId;
        this.poster = poster;
        this.textField = textField;
        this.time = time;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
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
}
