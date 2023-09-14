package com.example.congthucmonan.service;

import com.example.congthucmonan.model.Ingredient;
import com.example.congthucmonan.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> getIngredientById(Long ingredientId) {
        return ingredientRepository.findById(ingredientId);
    }

    public Optional<Ingredient> getIngredientByName(String ingredientName) {
        return ingredientRepository.findByName(ingredientName);
    }

    public List<Ingredient> getIngredientsByPriceRange(double minPrice, double maxPrice) {
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
