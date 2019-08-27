package com.example.EventCarPoolAPI;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentId")
	private Long commentId;
    private Long userId;
    private Long postId;
    private String textField;
    private LocalDate time;

	public Comment() {
	}

	public Comment(Long commentId, Long userId, Long postId, String textField, LocalDate time) {
		this.commentId = commentId;
		this.userId = userId;
		this.postId = postId;
		this.textField = textField;
		this.time = time;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
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
