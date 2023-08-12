package com.example.finalproject.controller;

import com.example.finalproject.dto.CarRequestDto;
import com.example.finalproject.dto.CarResponseDto;
import com.example.finalproject.entity.Car.CarEntity;
import com.example.finalproject.service.CarService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@AllArgsConstructor
@RestController
@RequestMapping("car")
@SecurityRequirement(name = "Bearer Authentication")
public class CarController {
    public final CarService service;


    @PostMapping("/sell")
    public String sell(@RequestBody CarRequestDto carRequestDto) {
        return service.sell(carRequestDto);
    }

    @PostMapping("/remove")
    public String remove(@RequestBody CarRequestDto carRequestDto) {
        return service.remove(carRequestDto);
    }

    @GetMapping("/getById/{id}")
    public CarResponseDto getById(@PathVariable("id") long id) {
        return service.getById(id);
    }


    @GetMapping("/all")
    public ArrayList<CarEntity> get() {
        return service.get();
    }

}
