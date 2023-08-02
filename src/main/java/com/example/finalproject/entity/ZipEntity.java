package com.example.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
@Table(name= "zip_entity")
public class ZipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer zip;
    private Integer lat;
    private Integer ing;
    private String city;
    private String state_id;
    private String state_name;
    private String zcta;
    private String parent_zcta;
    private Integer population;
    private Integer density;
    private Integer county_fips;
    private String county_name;
    private String county_weights;
    private String county_names_all;
    private String county_fips_all;
    private String imprecise;
    private String military;
    private String timezone;

}
