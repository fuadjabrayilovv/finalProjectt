package com.example.finalproject.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CarResponseDto {
    Integer year;
    String make;
    private Integer price;
    String model;
    private Integer mileage;
    String driveTrain;
    String Transmission;
    String fuelType;
    String exteriorColor;
    String interiorColor;

}
