package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FoodDTO {
    private String name;
    private String description;
    private String diseaseName; // Eşleşen hastalık adı
}
