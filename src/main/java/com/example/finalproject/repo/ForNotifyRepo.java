package com.example.finalproject.repo;

import com.example.finalproject.entity.Car.NotifyEntity;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@ConfigurationProperties(prefix="spring.datasourcesecond")
@Repository
public interface ForNotifyRepo extends CrudRepository<NotifyEntity, Long> {
    NotifyEntity findByMakeAndModelAndMaxPriceLessThanEqualAndMinYearGreaterThanEqual(String make, String model, int maxPrice, int minYear);

}
