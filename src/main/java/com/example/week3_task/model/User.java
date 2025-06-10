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
@Table(name = "userTable", uniqueConstraints = @UniqueConstraint(columnNames={"email"}))
public class User {
    @Id
    @GeneratedValue
    private UUID userId;
    @Column(nullable = false)
    private  String firstName;
    @Column(nullable = false)
    private  String lastName;
    @Column(nullable = false)
    private  String email;
    @Column(nullable = false)
    private  String phone;
    @Column(nullable = false)
    private  String password;

    @ManyToMany(mappedBy = "users")

private Set<Organisation> organisations;

    @PostPersist
    public void createDefaultOrganisation() {
        Organisation defaultOrg = new Organisation();
        defaultOrg.setName(this.firstName + "'s Organisation");
        this.organisations.add(defaultOrg);  // User → Org
        defaultOrg.getUsers().add(this);    // Org → User (bidirectional sync)
    }



}
