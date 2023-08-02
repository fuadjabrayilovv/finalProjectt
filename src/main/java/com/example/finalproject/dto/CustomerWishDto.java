package com.example.finalproject.dto;

import lombok.Data;

@Data
public class CustomerWishDto {
    String make;
    String model;
    Integer minYear;
    Integer maxPrice;
     String mail;

}
