package com.example.congthucmonan.service;

import com.example.congthucmonan.model.Dish;
import com.example.congthucmonan.model.Recipe;
import com.example.congthucmonan.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@NoArgsConstructor
@Service
public class RecipeService {
    @Autowired
    private  RecipeRepository recipeRepository;




    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId);
    }

    public Optional<Recipe> getRecipeByName(String recipeName) {
        return recipeRepository.findByRecipesName(recipeName);
    }

    public List<Recipe> getRecipesByDescription(String description) {
        return recipeRepository.findByRecipeDescription(description);
    }

    public List<Recipe> getRecipesByDifficulty(String difficulty) {
        return recipeRepository.findAllByDifficulty(difficulty);
    }

    public List<Recipe> getRecipesByDish(Dish dish) {
        return recipeRepository.findAllByDish(dish);
    }

    public List<Recipe> getRecipesByIngredients(List<String> ingredients) {
        return recipeRepository.findByIngredientsIn(ingredients);
    }



    public List<Recipe> getRecipesByTime(int preparationTimeMinutes, int cookingTimeMinutes) {
        return recipeRepository.findAllByPreparationTimeMinutesAndCookingTimeMinutes(
                preparationTimeMinutes, cookingTimeMinutes);
    }

    public List<Recipe> getRecipesByTotalTime(int totalTime) {
        List<Recipe> allRecipes = recipeRepository.findAll();
        List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : allRecipes) {
            int totalRecipeTime = recipe.getPreparationTimeMinutes() + recipe.getCookingTimeMinutes();
            if (totalRecipeTime < totalTime) {
                filteredRecipes.add(recipe);
            }
        }

        return filteredRecipes;
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }
}
