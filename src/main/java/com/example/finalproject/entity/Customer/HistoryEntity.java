package com.example.finalproject.entity.Customer;


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
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

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
