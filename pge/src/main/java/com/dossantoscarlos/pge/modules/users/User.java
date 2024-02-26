package com.dossantoscarlos.pge.modules.users;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;

    private String password;

    private String email;

    @Column(nullable = true)
    private Boolean validate_email;

}
