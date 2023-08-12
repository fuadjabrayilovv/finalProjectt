package com.example.finalproject.entity.Car;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class NotifyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mail;
    private final String make;
    private final String model;
    private final Integer minYear;
    private final Integer maxPrice;
}
