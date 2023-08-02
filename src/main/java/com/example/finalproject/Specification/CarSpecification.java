package com.example.finalproject.Specification;

import com.example.finalproject.dto.FilterDto;
import com.example.finalproject.entity.CarEntity;
import com.example.finalproject.repo.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
public class CarSpecification {
    public final CarRepository carRepository;


    public static Specification<CarEntity> withFilter(FilterDto dto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getMake() != null) {
                predicates.add(criteriaBuilder.equal(root.get("make"), dto.getMake()));
            }
            if (dto.getModel() != null) {
                predicates.add(criteriaBuilder.equal(root.get("model"), dto.getModel()));
            }
            if (dto.getType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("carType"), dto.getType()));
            }
            if (dto.getMaxMileage() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("mileage"), dto.getMaxMileage()));
            }
            if (dto.getMaxYear() != null && dto.getMinYear() != null) {
                predicates.add(criteriaBuilder.equal(root.get("productionYear"), dto.getMaxYear()));
            } else if (dto.getMinYear() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("year"), dto.getMinYear()));
            }else if (dto.getMaxYear() != null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("year"), dto.getMaxYear()));
            }
            if (dto.getMinPrice() != null && dto.getMaxPrice() != null) {
                // Add a condition for price within the specified range
                predicates.add(criteriaBuilder.between(root.get("price"), dto.getMinPrice(), dto.getMaxPrice()));
            } else if (dto.getMinPrice() != null) {
                // Add a condition for price greater than or equal to minPrice
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), dto.getMinPrice()));
            } else if (dto.getMaxPrice() != null) {
                // Add a condition for price less than or equal to maxPrice
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), dto.getMaxPrice()));
            }if (dto.getDriveTrain() != null) {
                predicates.add(criteriaBuilder.equal(root.get("driveTrain"), dto.getDriveTrain()));
            }
            if (dto.getTransmission() != null) {
                predicates.add(criteriaBuilder.equal(root.get("transmission"), dto.getTransmission()));
            }
            if (dto.getFuelType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("fuelType"), dto.getFuelType()));
            }
            if (dto.getExteriorColor() != null) {
                predicates.add(criteriaBuilder.equal(root.get("exteriorColor"), dto.getExteriorColor()));
            }
            if (dto.getInteriorColor() != null) {
                predicates.add(criteriaBuilder.equal(root.get("interiorColor"), dto.getInteriorColor()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}