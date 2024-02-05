package com.youcode.security.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDate creationDate;

    private LocalDate deadline;

    private boolean completed;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(255) DEFAULT 'REASSIGNED'")
    private RequestStatus status;
    //user who created the task

    @Enumerated(EnumType.STRING)
    @Column(name = "requests")
    private Request request;


    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

//user to whom the task is assigned

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

}
