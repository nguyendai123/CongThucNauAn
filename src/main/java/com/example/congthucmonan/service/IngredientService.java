package com.example.congthucmonan.service;

import com.example.congthucmonan.model.Ingredient;
import com.example.congthucmonan.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@NoArgsConstructor
@Service
public class IngredientService {
    @Autowired
    private  IngredientRepository ingredientRepository;



    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> getIngredientById(Long ingredientId) {
        return ingredientRepository.findById(ingredientId);
    }

    public Optional<Ingredient> getIngredientByName(String ingredientName) {
        return ingredientRepository.findByIngredientName(ingredientName);
    }

    public List<Ingredient> getIngredientsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return ingredientRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Ingredient> getIngredientsBySource(String source) {
        return ingredientRepository.findBySource(source);
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Long ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }
}
