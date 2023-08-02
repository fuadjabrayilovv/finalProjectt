package com.example.finalproject.util;

import com.example.finalproject.dto.CarRequestDto;
import com.example.finalproject.dto.CarResponseDto;
import com.example.finalproject.entity.CarEntity;
import com.example.finalproject.entity.NotifyEntity;
import com.example.finalproject.repo.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CarMapping {
    public final CarRepository carRepository;
    public CarEntity carDtoToCarDao(CarRequestDto carRequestDto){
        CarEntity carEntity = CarEntity.builder()
                .productionYear(carRequestDto.getYear())
                .price(carRequestDto.getPrice())

                .model(carRequestDto.getModel())
                .make(carRequestDto.getMake())
                .mileage(carRequestDto.getMileage())
                .driveTrain(carRequestDto.getDriveTrain())
                .exteriorColor(carRequestDto.getExteriorColor())
                .fuelType(carRequestDto.getFuelType())
                .interiorColor(carRequestDto.getInteriorColor())
                .Transmission(carRequestDto.getTransmission())

                .build();
        return carEntity;
    }
    public NotifyEntity carDtoToNotifyEntity(CarRequestDto carRequestDto){
        NotifyEntity notifyEntity = NotifyEntity.builder().minYear(carRequestDto.getYear())
                .maxPrice(carRequestDto.getPrice())
                .model(carRequestDto.getModel())
                .make(carRequestDto.getMake()).build();
        return notifyEntity;
    }
    public CarResponseDto mapCarDaoToFindById(long id){

        CarEntity byId = carRepository.findById(id);
        return CarResponseDto.builder().year(byId.getProductionYear()).make(byId.getMake()).model(byId.getModel()).price(byId.getPrice()).build();
    }
}
