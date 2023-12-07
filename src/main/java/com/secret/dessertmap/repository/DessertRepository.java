package com.secret.dessertmap.repository;

import com.secret.dessertmap.entity.DessertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DessertRepository extends JpaRepository<DessertEntity, Integer> {

    List<DessertEntity> findByShopId(int shopId);

}
