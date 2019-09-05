package com.example.EventCarPoolAPI.posthandling;


import com.example.EventCarPoolAPI.userhandling.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "[Like]")
public class Like {
    /*
    Fungerar ej!
    PGA one-to-many mappning som ej inställt.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "likeId")
    private Long likeId;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="userId")
    private User userLiking;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="postId")
    private Post post;
    private LocalDate time;

    public Like() {}

    public Like(User userLiking, Post post) {
        this.userLiking = userLiking;
        this.post = post;
        setTime();
    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public User getUserLiking() {
        return userLiking;
    }

    public void setUserLiking(User userLiking) {
        this.userLiking = userLiking;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime() {
        this.time = LocalDate.now();
    }
}
