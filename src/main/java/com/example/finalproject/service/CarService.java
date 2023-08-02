package com.example.finalproject.service;

import com.example.finalproject.Specification.CarSpecification;
import com.example.finalproject.dto.*;
import com.example.finalproject.entity.CarEntity;
import com.example.finalproject.entity.CustomerWishEntity;
import com.example.finalproject.entity.NotifyEntity;
import com.example.finalproject.repo.CarRepository;
import com.example.finalproject.repo.ForNotifyRepo;
import com.example.finalproject.repo.NotifyRepo;
import com.example.finalproject.util.CarMapping;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
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
    public final EmailService emailService;
    public final NotifyRepo notifyRepo;
    public final ForNotifyRepo forNotifyRepo;
    private final JavaMailSender mailSender;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quality")
    public String sell(CarRequestDto carRequestDto) {
        CarEntity carDtoToCarEntity = carMapping.carDtoToCarDao(carRequestDto);
        NotifyEntity notifyEntity = carMapping.carDtoToNotifyEntity(carRequestDto);
        log.info("got the info of the car");
        carRepository.save(carDtoToCarEntity);
        forNotifyRepo.save(notifyEntity);
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
//    public void update( CarRequestDto carRequestDto) {
//        ArrayList<CarEntity> all = (ArrayList<CarEntity>) carRepository.findAll();
//        for (CarEntity r :
//                all) {
//            if (r.getModel().equals(carRequestDto.getModel())) {
//                r.setMake(carRequestDto.getModel());
//                r.setPrice(carRequestDto.getPrice());
//                r.setModel(carRequestDto.getModel());
//                r.setProductionYear(carRequestDto.getProductionYear());
//                CarEntity save = carRepository.save(r);
//                log.info("saved changes in" + r.getId());
//                return "succesfully updated " +
//            } else {
//                log.info("incorrect password");
//            }
//        }
//    }


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
    public List<CarEntity> mainFilter(FilterDto dto) {
        if (dto.getMake() != null && dto.getModel() != null && dto.getMaxPrice() != null && dto.getMaxMileage() != null) {
            return carRepository
                    .findByMakeAndModelAndPriceIsLessThanEqualAndMileageIsLessThanEqual(dto.getMake(), dto.getModel(), dto.getMaxPrice(), dto.getMaxMileage());
        }
        if (dto.getMake() != null && dto.getModel() == null && dto.getMaxPrice() != null && dto.getMaxMileage() != null) {
            return carRepository
                    .findByMakeAndPriceIsLessThanEqualAndMileageIsLessThanEqual(dto.getMake(), dto.getMaxPrice(), dto.getMaxMileage());
        }
        if (dto.getMake() != null && dto.getMaxMileage() == null && dto.getMaxPrice() != null && dto.getModel() == null) {
            return carRepository
                    .findByMakeAndPriceIsLessThanEqual(dto.getMake(), dto.getMaxPrice());
        }
        if (dto.getMake() != null && dto.getModel() != null && dto.getMaxMileage() == null && dto.getMaxPrice() != null) {
            return carRepository
                    .findByMakeAndModelAndPriceIsLessThanEqual(dto.getMake(), dto.getModel(), dto.getMaxPrice());
        }
        if (dto.getMake() != null && dto.getModel() == null && dto.getMaxMileage() != null && dto.getMaxPrice() == null) {
            return carRepository
                    .findByMakeAndMileageIsLessThanEqual(dto.getMake(), dto.getMaxMileage());
        }

        if (dto.getMake() == null && dto.getModel() == null && dto.getMaxPrice() != null && dto.getMaxMileage() == null) {
            return carRepository
                    .findByPriceIsLessThanEqual(dto.getMaxPrice());
        }
        if (dto.getMake() == null && dto.getModel() == null && dto.getMaxPrice() == null && dto.getMaxMileage() != null) {
            return carRepository
                    .findByMileageIsLessThanEqual(dto.getMaxMileage());
        }
        if (dto.getMake() == null && dto.getMaxMileage() != null && dto.getMaxPrice() != null && dto.getModel() == null) {
            return carRepository.findByPriceIsLessThanEqualAndMileageIsLessThanEqual(dto.getMaxPrice(), dto.getMaxMileage());
        }
        return null;


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
    public List<CarEntity> testFilter(FilterDto dto){
        return carRepository.findByMakeAndModelAndCarTypeAndMileageAndProductionYearAndPrice(dto.getMake(), dto.getModel(), dto.getType(), dto.getMaxMileage(), dto.getMaxYear(), dto.getMaxPrice());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quality")
    @Scheduled(fixedRate = 86400000)
    public void notifyWhen() {
        ArrayList<CustomerWishEntity> all = (ArrayList<CustomerWishEntity>) notifyRepo.findAll();
        for (CustomerWishEntity dto :
                all) {
            NotifyEntity checker = forNotifyRepo.findByMakeAndModelAndMaxPriceLessThanEqualAndMinYearGreaterThanEqual(
                    dto.getMake(),
                    dto.getModel(),
                    dto.getMaxPrice(),
                    dto.getMinYear());
            CustomerWishEntity customerWish = notifyRepo.findByMakeAndModelAndMaxPriceLessThanEqualAndMinYearGreaterThanEqual(
                    dto.getMake(),
                    dto.getModel(),
                    dto.getMaxPrice(),
                    dto.getMinYear());
            if (checker.getMake().equals(customerWish.getMake()) && checker.getModel().equals(customerWish.getModel()) && checker.getMaxPrice().equals(customerWish.getMaxPrice()) && checker.getMinYear().equals(customerWish.getMinYear())) {

                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setTo(dto.getMail());
                msg.setFrom("fuad.vidadi12@gmail.com");
                msg.setSubject("car shop");
                msg.setText("there is/are cars for your request: \n " + checker.getId());

                mailSender.send(msg);

            }
        }

    }
    public List<CarEntity> searchCars(FilterDto filterDTO) {
        return carRepository.findAll(CarSpecification.withFilter(filterDTO));
    }


}
