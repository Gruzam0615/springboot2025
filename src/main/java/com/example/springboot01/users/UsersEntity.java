package com.example.springboot01.users;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "Users")
@Table(name = "Users")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usersIndex")
    private Long usersIndex;
    @Column(name = "usersUUID")
    private UUID usersUUID;
    @Column(name = "usersAccount")
    private String usersAccount;
    @Column(name = "usersPassword")
    private String usersPassword;
    @Column(name = "usersCreated")
    private LocalDateTime usersCreated;
    @Column(name = "usersUpdated")
    private LocalDateTime usersUpdated;

}
