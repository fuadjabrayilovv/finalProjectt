package com.example.finalproject.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer productionYear;
    private Integer price;
    private String make;
    private String model;
    private Integer mileage;

    private String driveTrain;
    private String Transmission;
    private String fuelType;
    private String exteriorColor;
    private String interiorColor;
}
