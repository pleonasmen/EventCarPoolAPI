package com.example.EventCarPoolAPI.futureexpansionclasses;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "[Group]")
public class Group {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "groupId")
    private Long id;
    private String groupName;
    private LocalDate registrationDate;

    Group() {}

    Group(String groupName) {
        setGroupName(groupName);
        setRegistrationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate() {
        this.registrationDate = LocalDate.now();
    }
}
