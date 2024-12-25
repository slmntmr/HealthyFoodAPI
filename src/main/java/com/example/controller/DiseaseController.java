package com.example.controller;


import com.example.dto.FoodDTO;

import com.example.service.DiseaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@RequestMapping("/api/diseases")
public class DiseaseController {


    private final DiseaseService diseaseService;

    // Manuel constructor ekliyoruz
    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }


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
