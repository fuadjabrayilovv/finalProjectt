package com.example.finalproject.service;

import com.example.finalproject.Specification.CarSpecification;
import com.example.finalproject.dto.CarRequestDto;
import com.example.finalproject.dto.CarResponseDto;
import com.example.finalproject.dto.CustomerWishDto;
import com.example.finalproject.dto.FilterDto;
import com.example.finalproject.entity.Car.CarEntity;
import com.example.finalproject.entity.Car.NotifyEntity;
import com.example.finalproject.entity.Customer.CustomerWishEntity;
import com.example.finalproject.entity.Customer.HistoryEntity;
import com.example.finalproject.repo.*;
import com.example.finalproject.util.CarMapping;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CarService {
    public final CarRepository carRepository;
    public final CarMapping carMapping;
    public final NotifyRepo notifyRepo;
    public final ForNotifyRepo forNotifyRepo;
    private final HistoryRepo historyRepo;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quality")
    public String sell(CarRequestDto carRequestDto) {
        CarEntity carDtoToCarEntity = carMapping.carDtoToCarDao(carRequestDto);
        NotifyEntity notifyEntity = carMapping.carDtoToNotifyEntity(carRequestDto);
        HistoryEntity historyEntity = carMapping.carDtoToHistoryDao(carRequestDto);
        log.info("got the info of the car");
        carRepository.save(carDtoToCarEntity);
        forNotifyRepo.save(notifyEntity);
        historyRepo.save(historyEntity);
        log.info("successfully saved to db");
        return "successfully saved " + carDtoToCarEntity;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quality")
    public String remove(CarRequestDto carRequestDto) {
        CarEntity carDtoToCarEntity = carMapping.carDtoToCarDao(carRequestDto);
        log.info("got the car, starting to delete...");
        carRepository.delete(carDtoToCarEntity);
        log.info(" successfully deleted ");
        return "successfully deleted" + carDtoToCarEntity + "from carList";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quality")
    public ArrayList<CarEntity> get() {
        log.info("finding everything.");
        ArrayList<CarEntity> all = (ArrayList<CarEntity>) carRepository.findAll();
        log.info("returning everything");
        return all;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quality")
    public CarResponseDto getById(long id) {
        log.info("finding by ID");
        CarResponseDto responseDto = carMapping.mapCarDaoToFindById(id);
        log.info("found the object,returning...");
        return responseDto;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quality")
    public void wishList(CustomerWishDto dto) {
        CustomerWishEntity entity = CustomerWishEntity
                .builder()
                .model(dto.getModel())
                .minYear(dto.getMinYear())
                .make(dto.getMake())
                .mail(dto.getMail())
                .maxPrice(dto.getMaxPrice())
                .build();
        notifyRepo.save(entity);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quality")
    public List<CarEntity> searchCars(FilterDto filterDTO) {
        return carRepository.findAll(CarSpecification.withFilter(filterDTO));
    }
}
