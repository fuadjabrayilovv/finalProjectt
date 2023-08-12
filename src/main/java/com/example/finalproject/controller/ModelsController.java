package com.example.finalproject.controller;

import com.example.finalproject.dto.CustomerWishDto;
import com.example.finalproject.dto.FilterDto;
import com.example.finalproject.entity.Car.CarEntity;
import com.example.finalproject.service.CarService;
import com.example.finalproject.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("carModels")
@RestController
@SecurityRequirement(name = "Bearer Authentication")
public class ModelsController {

    private final CarService carService;
    private final UserService userService;
    @GetMapping("wishList")
    public void wishList(CustomerWishDto customerWishDto){
        carService.wishList(customerWishDto);
    }
    @GetMapping("carSearch")
    public List<CarEntity> searchCars(@RequestBody FilterDto filterDTO) {
        return carService.searchCars(filterDTO);
    }
    @GetMapping("savedSearch")
    public void savedSearch(@RequestBody FilterDto dto){
         userService.savedSearch(dto);
    }
    }



