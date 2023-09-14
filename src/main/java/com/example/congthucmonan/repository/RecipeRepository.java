package com.example.congthucmonan.repository;

import com.example.congthucmonan.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByRecipesName(String name);

    List<Recipe> findByRecipeDescription(String description);

    List<Recipe> findAllByDifficulty(String difficulty);

    List<Recipe> findAllByDish(String dish);

    List<Recipe> findByIngredientsIn(List<String> ingredients);

    List<Recipe> findAllByPreparationTimeMinutesAndCookingTimeMinutes(int preparationTimeMinutes, int cookingTimeMinutes);
}