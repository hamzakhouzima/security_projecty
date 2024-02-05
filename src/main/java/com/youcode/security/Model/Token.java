package com.youcode.security.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String type; // Reassignment or Deletion
    private int count;

    // Getters and setters
}