package com.example.controller;

import com.example.entity.Disease;
import com.example.entity.Food;
import com.example.repository.DiseaseRepository;
import com.example.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FoodDiseaseController {

    private final FoodRepository foodRepository;
    private final DiseaseRepository diseaseRepository;

    @PostMapping("/bulk-add")
    public ResponseEntity<?> addBulkData(@RequestBody List<Food> foods) {
        foods.forEach(food -> {
            // Mevcut besin kontrolü
            Food existingFood = foodRepository.findByName(food.getName())
                    .orElseGet(() -> {
                        Food newFood = new Food();
                        newFood.setName(food.getName());
                        newFood.setDescription(food.getDescription());
                        return foodRepository.save(newFood);
                    });

            // Hastalıkları kontrol et
            if (food.getDiseases() != null) {
                food.getDiseases().forEach(disease -> {
                    Disease existingDisease = diseaseRepository.findByName(disease.getName())
                            .orElseGet(() -> {
                                Disease newDisease = new Disease();
                                newDisease.setName(disease.getName());
                                newDisease.setDescription(disease.getDescription());
                                return diseaseRepository.save(newDisease);
                            });

                    // İlişkileri yönet
                    existingFood.getDiseases().add(existingDisease);
                    existingDisease.getFoods().add(existingFood);
                });
            }

            // Güncel ilişkiyi kaydet
            foodRepository.save(existingFood);
        });

        return ResponseEntity.ok("Data added successfully");
    }
}