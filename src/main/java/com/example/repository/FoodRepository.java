package com.example.repository;

import com.example.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findByName(String name); // Mevcut yöntem (tam eşleşme)
    @Query("SELECT f FROM Food f WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Food> findByNameContainingIgnoreCase(String name);
}
