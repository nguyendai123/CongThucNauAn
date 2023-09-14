package com.example.congthucmonan.repository;

import com.example.congthucmonan.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByName(String name);

    List<Ingredient> findByPriceBetween(double min, double max);

    List<Ingredient> findBySource(String source);
}
