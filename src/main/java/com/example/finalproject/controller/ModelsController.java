package com.example.finalproject.controller;

import com.example.finalproject.dto.CustomerWishDto;
import com.example.finalproject.dto.FilterDto;
//import com.example.finalproject.dto.CustomerWishDto;
import com.example.finalproject.entity.CarEntity;
//import com.example.finalproject.entity.NotifyEntity;
//import com.example.finalproject.repo.NotifyRepo;
import com.example.finalproject.service.CarService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("carModels")
@RestController
@SecurityRequirement(name = "Bearer Authentication")
public class ModelsController {

    private final CarService service;
//    private final NotifyRepo repository;

    @GetMapping("carFilter")
    public ResponseEntity<List<CarEntity>> filter(@RequestBody FilterDto dto)  {
        return  ResponseEntity.ok(service.mainFilter(dto));
    }
    @GetMapping("wishList")
    public void wishList(CustomerWishDto customerWishDto){
        service.wishList(customerWishDto);
    }
    @GetMapping("carSearch")
    public List<CarEntity> searchCars(@RequestBody FilterDto filterDTO) {
        return service.searchCars(filterDTO);
    }


    }



