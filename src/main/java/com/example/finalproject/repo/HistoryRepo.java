package com.example.finalproject.repo;

import com.example.finalproject.entity.Customer.HistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepo extends CrudRepository<HistoryEntity, Long> {
}
