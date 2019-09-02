package com.example.EventCarPoolAPI;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentId")
	private Long commentId;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="userId")
	private User userCommenting;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="postId")
    private Post post;
    private String textField;
    private LocalDate time;


	public Comment() {
	}

	public Comment(String textField, User userCommenting, Post post) {
		this.textField = textField;
		this.userCommenting = userCommenting;
		this.post = post;
		setTime();
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUserCommenting() {
		return userCommenting;
	}

	public void setUserCommenting(User userCommenting) {
		this.userCommenting = userCommenting;
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

	public void setTime() {
		this.time = LocalDate.now();
	}
}
