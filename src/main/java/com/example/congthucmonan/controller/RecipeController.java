package com.example.congthucmonan.controller;

import com.example.congthucmonan.model.Recipe;
import com.example.congthucmonan.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);
        return recipe.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Recipe> getRecipeByName(@PathVariable("name") String name) {
        Optional<Recipe> recipe = recipeService.getRecipeByName(name);
        return recipe.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<Recipe>> getRecipesByDescription(@PathVariable("description") String description) {
        List<Recipe> recipes = recipeService.getRecipesByDescription(description);
        if (!recipes.isEmpty()) {
            return ResponseEntity.ok(recipes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Recipe>> getRecipesByDifficulty(@PathVariable("difficulty") String difficulty) {
        List<Recipe> recipes = recipeService.getRecipesByDifficulty(difficulty);
        if (!recipes.isEmpty()) {
            return ResponseEntity.ok(recipes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dish/{dish}")
    public ResponseEntity<List<Recipe>> getRecipesByDish(@PathVariable("dish") String dish) {
        List<Recipe> recipes = recipeService.getRecipesByDish(dish);
        if (!recipes.isEmpty()) {
            return ResponseEntity.ok(recipes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ingredients")
    public ResponseEntity<List<Recipe>> getRecipesByIngredients(@RequestParam("ingredient") List<String> ingredients) {
        List<Recipe> recipes = recipeService.getRecipesByIngredients(ingredients);
        if (!recipes.isEmpty()) {
            return ResponseEntity.ok(recipes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/time")
    public ResponseEntity<List<Recipe>> getRecipesByTime(
            @RequestParam("preparationTimeMinutes") int preparationTimeMinutes,
            @RequestParam("cookingTimeMinutes") int cookingTimeMinutes) {
        List<Recipe> recipes = recipeService.getRecipesByTime(preparationTimeMinutes, cookingTimeMinutes);
        if (!recipes.isEmpty()) {
            return ResponseEntity.ok(recipes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/total-time")
    public ResponseEntity<List<Recipe>> getRecipesByTotalTime(@RequestParam("totalTime") int totalTime) {
        List<Recipe> recipes = recipeService.getRecipesByTotalTime(totalTime);
        if (!recipes.isEmpty()) {
            return ResponseEntity.ok(recipes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeService.createRecipe(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipe) {
        Optional<Recipe> existingRecipe = recipeService.getRecipeById(id);
        if (existingRecipe.isPresent()) {
            recipe.setRecipesID(id);
            Recipe updatedRecipe = recipeService.updateRecipe(recipe);
            return ResponseEntity.ok(updatedRecipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable("id") Long id) {
        Optional<Recipe> existingRecipe = recipeService.getRecipeById(id);
        if (existingRecipe.isPresent()) {
            recipeService.deleteRecipe(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
