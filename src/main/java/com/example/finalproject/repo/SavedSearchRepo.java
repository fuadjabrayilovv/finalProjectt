package com.example.finalproject.repo;

import com.example.finalproject.entity.Customer.SavedSearchEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedSearchRepo extends CrudRepository<SavedSearchEntity, Long> {

}
