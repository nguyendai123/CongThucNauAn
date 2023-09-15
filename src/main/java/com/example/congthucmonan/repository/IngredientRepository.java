package com.example.congthucmonan.repository;

import com.example.congthucmonan.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByIngredientName(String ingredientName);

    List<Ingredient> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Ingredient> findBySource(String source);
}
