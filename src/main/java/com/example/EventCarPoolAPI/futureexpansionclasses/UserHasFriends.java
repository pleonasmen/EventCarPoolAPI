package com.example.EventCarPoolAPI.futureexpansionclasses;


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
    @Column (name = "user1_id")
    private Long user1Id;
    @Column (name = "user2_id")
    private Long user2Id;
    private String status;
    private Long action_user_id;

    UserHasFriends() {}

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public Long getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Long user1Id) {
        this.user1Id = user1Id;
    }

    public Long getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Long user2Id) {
        this.user2Id = user2Id;
    }

    public Long getAction_user_id() {
        return action_user_id;
    }

    public void setAction_user_id(Long action_user_id) {
        this.action_user_id = action_user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
