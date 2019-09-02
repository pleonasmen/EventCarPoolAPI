package com.example.EventCarPoolAPI;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User_Has_Friend")
public class UserHasFriends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "relationship_id")
    private Long relationshipId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user1_id")
    private User friend1;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user2_id")
    private User friend2;
    private String status;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="action_user_id")
    @JsonIgnore
    private User actionUserId;

    UserHasFriends() {}

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public User getFriend1() {
        return friend1;
    }

    public void setFriend1(User friend1) {
        this.friend1 = friend1;
    }

    public User getFriend2() {
        return friend2;
    }

    public void setFriend2(User friend2) {
        this.friend2 = friend2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public void setActionUserId(User actionUserId) {
        this.actionUserId = actionUserId;
    }
}
