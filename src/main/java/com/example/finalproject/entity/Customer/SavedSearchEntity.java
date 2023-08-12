package com.example.finalproject.entity.Customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class SavedSearchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;

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
