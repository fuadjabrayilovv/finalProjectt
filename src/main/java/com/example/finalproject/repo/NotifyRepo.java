package com.example.finalproject.repo;

import com.example.finalproject.entity.CarEntity;
import com.example.finalproject.entity.CustomerWishEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifyRepo extends CrudRepository<CustomerWishEntity, Long> {
     CustomerWishEntity findByMakeAndModelAndMaxPriceLessThanEqualAndMinYearGreaterThanEqual(String make, String model, int maxPrice, int minYear);



}
