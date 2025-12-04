package com.tienda.tcg.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class User {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
@SequenceGenerator(
        name = "user_seq_gen",
        sequenceName = "USER_SEQ",
        allocationSize = 1
)
@Column(name = "ID")
private Long id;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ROLE", nullable = false)
    private String role;
}
