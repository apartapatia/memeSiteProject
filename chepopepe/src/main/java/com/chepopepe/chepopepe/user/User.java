package com.chepopepe.chepopepe.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String displayName;
    private String password;
}
