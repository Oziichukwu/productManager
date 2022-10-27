package com.example.productManager.data.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class ProductUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    private String username;

    private String role;

    private String password;

    private boolean enabled;
}
