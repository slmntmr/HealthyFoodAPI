package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiseaseDTO {
    private String name;
    private String description;
    private String foodName; // Eşleşen besin adı
}
