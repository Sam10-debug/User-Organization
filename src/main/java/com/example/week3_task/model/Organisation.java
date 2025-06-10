package com.example.week3_task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Organisation {
    @Id
    @GeneratedValue

    private UUID orgId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;




    @ManyToMany
    private Set<User> users;




}
