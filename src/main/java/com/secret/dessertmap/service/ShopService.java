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


    // memberController에서 로그인 아이디에 해당하는 가게들 한번에 꺼내기
    public List<ShopEntity> findByMemeberId(String memberId){
        List<ShopEntity> shopEntity = shopRepository.findByMemberId(memberId);
        return shopEntity;
    }




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


    public void update(ShopEntity shopEntity){
        shopRepository.save(shopEntity);
    }


    public void delete(int shopId){
        shopRepository.deleteById(shopId);
    }


}
