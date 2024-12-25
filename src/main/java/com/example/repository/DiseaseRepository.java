package com.example.repository;

import com.example.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    Optional<Disease> findByName(String name); // Mevcut yöntem (tam eşleşme)



    @Query("SELECT d FROM Disease d WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Disease> findByNameContainingIgnoreCase(String name);

}
