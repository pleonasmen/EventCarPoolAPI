package com.example.EventCarPoolAPI;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Post")
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "postId")
    private Long postId;
    private Long userId;
    private String textField;
    private LocalDate time;

    public Post() {
    }

    public Post(Long postId, Long userId, String textField, LocalDate time) {
        this.postId = postId;
        this.userId = userId;
        this.textField = textField;
        this.time = time;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
