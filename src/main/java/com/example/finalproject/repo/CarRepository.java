package com.example.finalproject.repo;

import com.example.finalproject.dto.FilterDto;
import com.example.finalproject.entity.CarEntity;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@ConfigurationProperties(prefix = "spring.datasource")
@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long>, JpaSpecificationExecutor<CarEntity> {



    //native query
//@Query(value = "SELECT * FROM car_entity WHERE make IS NULL AND model IS NULL AND BETWEEN price", nativeQuery = true)
//List<CarEntity> findByPrice(int minPrice, int maxPrice);

    @Query(value = "SELECT * FROM car_entity c " +
            "WHERE (:make IS NULL OR c.make =  :make) " +
            "AND (:model IS NULL OR c.model = :model) " +
            "AND (:car_type IS NULL OR c.car_type = :car_type) " +
            "AND (:mileage IS NULL OR c.mileage = :mileage) " +
            "AND (:production_year IS NULL OR c.production_year = :production_year) " +
            "AND (:price IS NULL OR c.price = :price)",
            nativeQuery = true)
    List<CarEntity> findByMakeAndModelAndCarTypeAndMileageAndProductionYearAndPrice(
            @Param("make") String make,
            @Param("model") String model,
            @Param("car_type") String carType,
            @Param("mileage") Integer mileage,
            @Param("production_year") Integer productionYear,
            @Param("price") Integer price
    );



    //price
    List<CarEntity> findByPriceIsLessThanEqual(Integer maxPrice);


    //make and model and maxprice and maxmileage, make and model and minprice and maxmileage, make and model and maxprice and minmileage, make and model and minprice and minmileage
    List<CarEntity> findByMakeAndModelAndPriceIsLessThanEqualAndMileageIsLessThanEqual(String make, String model, Integer maxPrice, Integer maxMileage);
    // make and maxprice, make and minprice, make and between min and max price
    List<CarEntity> findByMakeAndPriceIsLessThanEqual(String make, Integer maxPrice);
    List<CarEntity> findByMakeAndPriceIsLessThanEqualAndMileageIsLessThanEqual(String make, Integer maxPrice, Integer maxMileage);

    List<CarEntity> findByMakeAndModelAndPriceIsLessThanEqual(String make, String model, Integer maxPrice);



    // make and maxmileage, make and minmileage, make and between mileage
    List<CarEntity> findByMakeAndMileageIsLessThanEqual(String make, Integer maxMileage);

    // maxmileage, minmileage
    List<CarEntity> findByMileageIsLessThanEqual(Integer maxMileage);



    // maxprice maxmileage, minprice and minmileage, maxprice and minmileage, minprice and maxmileage, minprice and between mileage, between price and maxmileage, between price and minmileage
    List<CarEntity> findByPriceIsLessThanEqualAndMileageIsLessThanEqual(Integer maxPrice, Integer maxMileage);
    CarEntity findById(long id);
}
