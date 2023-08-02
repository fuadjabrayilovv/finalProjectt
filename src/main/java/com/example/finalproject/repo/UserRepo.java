package com.example.finalproject.repo;

import com.example.finalproject.entity.LoginEntity;
import lombok.extern.java.Log;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<LoginEntity, Long> {

    LoginEntity findUsersEntityByEmail(String email);
//    LoginEntity findByUsername(String username);
}
