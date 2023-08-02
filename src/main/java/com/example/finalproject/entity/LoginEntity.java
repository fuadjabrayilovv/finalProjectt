package com.example.finalproject.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @NotNull
//    private String username;
    @NotNull
    private String email;

    @NotNull
    private String role;

    @NotNull
    private String password;
}
