package com.example.EventCarPoolAPI;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

	public Comment(Long commentId, String textField, LocalDate time) {
		this.commentId = commentId;
		this.textField = textField;
		this.time = time;
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

	public void setTime(LocalDate time) {
		this.time = time;
	}
}
