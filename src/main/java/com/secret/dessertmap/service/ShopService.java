package com.secret.dessertmap.service;

import com.secret.dessertmap.entity.ShopEntity;
import com.secret.dessertmap.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public List<ShopEntity> findAll(){
        List<ShopEntity> shopEntityList = shopRepository.findAll();

        return shopEntityList;
    }

    public void save(ShopEntity shopEntity){
        shopRepository.save(shopEntity);
    }

    public ShopEntity findById(int shopId){
        Optional<ShopEntity> shopEntity = shopRepository.findById(shopId);
        return shopEntity.get();
    }
}
