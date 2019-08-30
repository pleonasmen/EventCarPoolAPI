package com.example.EventCarPoolAPI;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "User_Gives_Reference_To_User")
public class UserGivesReferenceToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long referenceId;
    private Long giverId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="receiverId")
    private User userReceiving;
    private String referenceType;
    private LocalDate time;
    private String giverRole;
    private String receiverRole;
    private String textField;
    
    public UserGivesReferenceToUser() {
    }

    public UserGivesReferenceToUser(Long giverId, String referenceType, LocalDate time, String giverRole, String receiverRole, String textField) {
        this.giverId = giverId;
        this.referenceType = referenceType;
        this.time = time;
        this.giverRole = giverRole;
        this.receiverRole = receiverRole;
        this.textField = textField;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public Long getGiverId() {
        return giverId;
    }

    public void setGiverId(Long giverId) {
        this.giverId = giverId;
    }

    public User getUserReceiving() {
        return userReceiving;
    }

    public void setUserReceiving(User userReceiving) {
        this.userReceiving = userReceiving;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getGiverRole() {
        return giverRole;
    }

    public void setGiverRole(String giverRole) {
        this.giverRole = giverRole;
    }

    public String getReceiverRole() {
        return receiverRole;
    }

    public void setReceiverRole(String receiverRole) {
        this.receiverRole = receiverRole;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }
}
