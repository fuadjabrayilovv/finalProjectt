package com.example.finalproject.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CarRequestDto {
     Integer year;
     private Integer price;
     String make;
     String model;
     private Integer mileage;
     String driveTrain;
     String Transmission;
     String fuelType;
     String exteriorColor;
     String interiorColor;




}
