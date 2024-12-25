package com.example.dto;

public class FoodDTO {
    private String name;
    private String description;
    private String diseaseName; // Eşleşen hastalık adı

    // Boş constructor
    public FoodDTO() {}

    // Tüm argümanları kabul eden constructor
    public FoodDTO(String name, String description, String diseaseName) {
        this.name = name;
        this.description = description;
        this.diseaseName = diseaseName;
    }

    // Getter ve Setter metotları
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
}
