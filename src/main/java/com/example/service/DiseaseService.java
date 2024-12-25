package com.example.service;

import com.example.dto.FoodDTO;
import com.example.entity.Disease;
import com.example.repository.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public List<FoodDTO> getRecommendedFoods(String diseaseName) {
        // Küçük/büyük harf duyarsız ve kısmi eşleşme ile hastalıkları ara
        List<Disease> diseases = diseaseRepository.findByNameContainingIgnoreCase(diseaseName);

        // Eğer sonuç bulunamazsa hata döndür
        if (diseases.isEmpty()) {
            throw new RuntimeException("Hastalık bulunamadı: " + diseaseName);
        }

        // Eşleşen hastalıkların besinlerini döndür ve hastalık adı ekle
        return diseases.stream()
                .flatMap(disease -> disease.getFoods().stream()
                        .map(food -> new FoodDTO(food.getName(), food.getDescription(), disease.getName())))
                .distinct()
                .collect(Collectors.toList());
    }
}
