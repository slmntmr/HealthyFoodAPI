package com.example.controller;


import com.example.dto.FoodDTO;
import com.example.entity.Food;
import com.example.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diseases")
public class DiseaseController {

    private final DiseaseService diseaseService;

    @GetMapping("/{name}/recommended-foods")
    public ResponseEntity<?> getRecommendedFoods(@PathVariable String name) {
        try {
            List<FoodDTO> foods = diseaseService.getRecommendedFoods(name);
            return ResponseEntity.ok(foods);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Hastalık bulunamadı: " + name);
        }
    }
}
