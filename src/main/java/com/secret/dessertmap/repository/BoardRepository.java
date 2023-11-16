package com.secret.dessertmap.repository;

import com.secret.dessertmap.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
}
