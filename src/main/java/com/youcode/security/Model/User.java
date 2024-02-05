package com.youcode.security.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "User")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "tokens")
    private int tokens ;

    @OneToMany
    @JoinColumn(name ="task_id")
    private List<Task> tasks;

//    @ManyToOne
//    @JoinColumn(name = "role_id")
    @Column(name = "Role")
    private Roles role;

    public User() {

    }
}



