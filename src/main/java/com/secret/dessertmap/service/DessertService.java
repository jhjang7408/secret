package com.secret.dessertmap.service;

import com.secret.dessertmap.entity.DessertEntity;
import com.secret.dessertmap.repository.DessertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DessertService {

    private final DessertRepository dessertRepository;


    public List<DessertEntity> findByShopId(int shopId){

        List<DessertEntity> dessertList = dessertRepository.findByShopId(shopId);

        return dessertList;
    }


    public void save(DessertEntity dessertEntity){
        dessertRepository.save(dessertEntity);
    }

    public void delete(int dessertId){
        dessertRepository.deleteById(dessertId);
    }

    public DessertEntity findByDessertId(int dessertId){

        DessertEntity dessertEntity = dessertRepository.findByDessertId(dessertId);

        return dessertEntity;
    }



}
