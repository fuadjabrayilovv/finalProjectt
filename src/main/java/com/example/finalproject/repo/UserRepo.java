package com.example.finalproject.repo;

import com.example.finalproject.entity.Customer.LoginEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<LoginEntity, Long> {

    LoginEntity findUsersEntityByEmail(String email);

    LoginEntity findByEmail(String username);
//    LoginEntity findByUsername(String username);
}
