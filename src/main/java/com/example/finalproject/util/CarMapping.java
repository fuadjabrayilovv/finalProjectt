package com.example.finalproject.util;

import com.example.finalproject.dto.CarRequestDto;
import com.example.finalproject.dto.CarResponseDto;
import com.example.finalproject.dto.FilterDto;
import com.example.finalproject.entity.Car.CarEntity;
import com.example.finalproject.entity.Car.NotifyEntity;
import com.example.finalproject.entity.Customer.HistoryEntity;
import com.example.finalproject.entity.Customer.SavedSearchEntity;
import com.example.finalproject.repo.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    public HistoryEntity carDtoToHistoryDao(CarRequestDto carRequestDto){
        Authentication sessionId = SecurityContextHolder.getContext().getAuthentication();

        String email = null;
        Object principal = sessionId.getPrincipal();

        if (principal instanceof User) {
            User userDetails = (User) principal;
            email = userDetails.getUsername();
        } else if (principal instanceof String) {
            email = (String) principal;
        }
        HistoryEntity carEntity = HistoryEntity.builder()
                .email(email)
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
    public SavedSearchEntity SearchDtoToSearchEntity(FilterDto dto){
        Authentication sessionId = SecurityContextHolder.getContext().getAuthentication();

        String email = null;
        Object principal = sessionId.getPrincipal();

        if (principal instanceof User) {
            User userDetails = (User) principal;
            email = userDetails.getUsername();
        } else if (principal instanceof String) {
            email = (String) principal;
        }
        SavedSearchEntity savedSearchEntity = SavedSearchEntity.builder()
                .email(email)
                .driveTrain(dto.getDriveTrain())
                .exteriorColor(dto.getExteriorColor())
                .fuelType(dto.getFuelType())
                .maxYear(dto.getMaxYear())
                .minPrice(dto.getMinPrice())
                .interiorColor(dto.getInteriorColor())
                .type(dto.getType())
                .maxMileage(dto.getMaxMileage())
                .Transmission(dto.getTransmission())
                .model(dto.getModel())
                .minYear(dto.getMinYear())
                .make(dto.getMake())
                .maxPrice(dto.getMaxPrice())
                .build();

        return savedSearchEntity;
    }
}
