package com.example.EventCarPoolAPI;


import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class UserGivesReferenceToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "giverId")
    private Long giverId;
    private Long receiverId;
    private String referenceType;
    private LocalDate time;
    private String giverRole;
    private String receiverRole;
    private String textField;


    public UserGivesReferenceToUser() {
    }

    public UserGivesReferenceToUser(Long giverId, Long receiverId, String referenceType, LocalDate time, String giverRole, String receiverRole, String textField) {
        this.giverId = giverId;
        this.receiverId = receiverId;
        this.referenceType = referenceType;
        this.time = time;
        this.giverRole = giverRole;
        this.receiverRole = receiverRole;
        this.textField = textField;
    }

    public Long getGiverId() {
        return giverId;
    }

    public void setGiverId(Long giverId) {
        this.giverId = giverId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
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
