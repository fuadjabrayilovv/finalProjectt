package com.example.finalproject.service;

import com.example.finalproject.entity.Car.NotifyEntity;
import com.example.finalproject.entity.Customer.CustomerWishEntity;
import com.example.finalproject.repo.ForNotifyRepo;
import com.example.finalproject.repo.NotifyRepo;
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

@Service
@AllArgsConstructor
@Slf4j
public class SchedulerService {
    public final NotifyRepo notifyRepo;
    public final ForNotifyRepo forNotifyRepo;
    public final JavaMailSender mailSender;
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
}
