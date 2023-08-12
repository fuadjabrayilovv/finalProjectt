package com.example.finalproject.service;

import com.example.finalproject.dto.FilterDto;
import com.example.finalproject.entity.Customer.SavedSearchEntity;
import com.example.finalproject.repo.SavedSearchRepo;
import com.example.finalproject.util.CarMapping;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    public final CarMapping carMapping;

    public final SavedSearchRepo searchRepo;
    public void savedSearch(FilterDto dto){
        SavedSearchEntity savedSearchEntity = carMapping.SearchDtoToSearchEntity(dto);
        searchRepo.save(savedSearchEntity);



    }
}
