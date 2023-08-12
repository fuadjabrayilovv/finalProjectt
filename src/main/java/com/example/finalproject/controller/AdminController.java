package com.example.finalproject.controller;

import com.example.finalproject.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class AdminController {
    public final UserRepo userRepo;

    public void adminPanel(@RequestBody boolean userList,@RequestBody boolean userCount){
        if(userList == true){
            userRepo.findAll();
        }else if(userCount == true){
            userRepo.count();
        }

    }
}
