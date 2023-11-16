package com.secret.dessertmap.repository;

import com.secret.dessertmap.entity.MemberEntity;
import com.secret.dessertmap.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository <ShopEntity, Integer> {

    Optional<ShopEntity> findById(int shopId);
}
