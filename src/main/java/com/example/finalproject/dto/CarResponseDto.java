package com.example.finalproject.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CarDto {
    String make;
    String model;
    int price;
    int year;
    int mileage;
}
