package com.example.finalproject.client;

import org.springframework.web.bind.annotation.GetMapping;

public interface CarClient {

    @GetMapping("makes")
//    @Headers({"X-RapidAPI-Key: e21b411f2bmsh336fc6768e9fa4bp1ba27ejsncccc61e2e8ba"})
    String carsData();
}

