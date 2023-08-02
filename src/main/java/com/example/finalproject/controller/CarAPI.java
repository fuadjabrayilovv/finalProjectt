package com.example.finalproject.controller;

import com.example.finalproject.dto.ZipDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController(value = "carApi")
@RequestMapping("carApi")

@SecurityRequirement(name = "Bearer Authentication")
public class CarAPI {

//    @RequestMapping("/cars")
//    public ResponseEntity<?> CarsInfo() throws RestClientException {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("X-RapidAPI-Key", "e21b411f2bmsh336fc6768e9fa4bp1ba27ejsncccc61e2e8ba");
//        httpHeaders.set("X-RapidAPI-Host", "us-zip-code-information.p.rapidapi.com");
//        HttpEntity<String> entity = new HttpEntity<>("body", httpHeaders);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<ZipDto[]> exchange = restTemplate.exchange("https://us-zip-code-information.p.rapidapi.com/", HttpMethod.GET, entity, ZipDto[].class);
//        ZipDto[] body = exchange.getBody();
//
//        return new ResponseEntity<>(exchange.getBody(), HttpStatus.OK);
//    }
//
}
