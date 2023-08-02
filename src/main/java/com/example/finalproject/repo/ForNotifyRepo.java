package com.example.finalproject.repo;

import com.example.finalproject.entity.NotifyEntity;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@ConfigurationProperties(prefix="spring.datasourcesecond")
@Repository
public interface ForNotifyRepo extends CrudRepository<NotifyEntity, Long> {
    NotifyEntity findByMakeAndModelAndMaxPriceLessThanEqualAndMinYearGreaterThanEqual(String make, String model, int maxPrice, int minYear);

}
