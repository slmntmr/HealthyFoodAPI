package com.example.controller;


import com.example.dto.DiseaseDTO;
import com.example.entity.Disease;
import com.example.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService foodService;

    // Manuel constructor ekliyoruz
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }



    @GetMapping("/{name}/related-diseases")
    public ResponseEntity<?> getRelatedDiseases(@PathVariable String name) {
        try {
            List<DiseaseDTO> diseases = foodService.getRelatedDiseases(name);
            return ResponseEntity.ok(diseases);
        } catch (RuntimeException e) {
            // Besin bulunamadığında hata mesajını düzenle
            return ResponseEntity.status(404).body("Besin bulunamadı: " + name);
        }
    }



}

