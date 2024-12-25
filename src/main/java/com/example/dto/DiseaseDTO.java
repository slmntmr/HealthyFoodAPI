package com.example.dto;

public class DiseaseDTO {
    private String name;
    private String description;
    private String foodName; // Eşleşen besin adı

    // Boş constructor
    public DiseaseDTO() {}

    // Tüm argümanları kabul eden constructor
    public DiseaseDTO(String name, String description, String foodName) {
        this.name = name;
        this.description = description;
        this.foodName = foodName;
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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
