package com.example.finalproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FilterDto {
    @JsonProperty(required = false)
    private String make;
    @JsonProperty(required = false)
    private String type;
    @JsonProperty(required = false)
    private String model;
    @JsonProperty(required = false)
    private Integer maxYear;
    @JsonProperty(required = false)
    private Integer minYear;
    @JsonProperty(required = false)
    private Integer maxPrice;
    @JsonProperty(required = false)
    private Integer minPrice;
    @JsonProperty(required = false)
    private Integer maxMileage;
    @JsonProperty(required = false)
    private String driveTrain;
    @JsonProperty(required = false)
    private String Transmission;
    @JsonProperty(required = false)
    private String fuelType;
    @JsonProperty(required = false)
    private String exteriorColor;
    @JsonProperty(required = false)
    private String interiorColor;

}