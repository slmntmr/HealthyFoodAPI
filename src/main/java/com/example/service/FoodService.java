package com.example.service;

import com.example.dto.DiseaseDTO;
import com.example.entity.Food;
import com.example.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class FoodService {

    private final FoodRepository foodRepository;

    // Manuel constructor ile bağımlılık enjeksiyonu
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<DiseaseDTO> getRelatedDiseases(String foodName) {
        // Küçük/büyük harf duyarsız ve kısmi eşleşme ile besinleri ara
        List<Food> foods = foodRepository.findByNameContainingIgnoreCase(foodName);

        // Eğer sonuç bulunamazsa hata döndür
        if (foods.isEmpty()) {
            throw new RuntimeException("Besin bulunamadı: " + foodName);
        }

        // Eşleşen besinlerin hastalıklarını döndür ve besin adı ekle
        return foods.stream()
                .flatMap(food -> food.getDiseases().stream()
                        .map(disease -> new DiseaseDTO(disease.getName(), disease.getDescription(), food.getName())))
                .distinct()
                .collect(Collectors.toList());
    }
}
