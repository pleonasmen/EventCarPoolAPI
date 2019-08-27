package com.example.EventCarPoolAPI;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Like")
public class Like {
    /*
    Fungerar ej!
    PGA one-to-many mappning som ej inställt.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "likeId")
    private Long likeId;
    private Long userId;
    private Long postId;
    private LocalDate time;



    public Like() {}

    public Like(Long likeId, Long userId, Long postId, LocalDate time) {
        this.likeId = likeId;
        this.userId = userId;
        this.postId = postId;
        this.time = time;
    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
