package com.example.congthucmonan.controller;

import com.example.congthucmonan.model.Ingredient;
import com.example.congthucmonan.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long id) {
        Optional<Ingredient> ingredient = ingredientService.getIngredientById(id);
        return ingredient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Ingredient> getIngredientByName(@PathVariable("name") String name) {
        Optional<Ingredient> ingredient = ingredientService.getIngredientByName(name);
        return ingredient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/price")
    public ResponseEntity<List<Ingredient>> getIngredientsByPriceRange(
            @RequestParam("min") double minPrice,
            @RequestParam("max") double maxPrice) {
        List<Ingredient> ingredients = ingredientService.getIngredientsByPriceRange(minPrice, maxPrice);
        if (!ingredients.isEmpty()) {
            return ResponseEntity.ok(ingredients);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/source/{source}")
    public ResponseEntity<List<Ingredient>> getIngredientsBySource(@PathVariable("source") String source) {
        List<Ingredient> ingredients = ingredientService.getIngredientsBySource(source);
        if (!ingredients.isEmpty()) {
            return ResponseEntity.ok(ingredients);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createdIngredient = ingredientService.createIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable("id") Long id, @RequestBody Ingredient ingredient) {
        Optional<Ingredient> existingIngredient = ingredientService.getIngredientById(id);
        if (existingIngredient.isPresent()) {
            ingredient.setIngredientID(id);
            Ingredient updatedIngredient = ingredientService.updateIngredient(ingredient);
            return ResponseEntity.ok(updatedIngredient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable("id") Long id) {
        Optional<Ingredient> existingIngredient = ingredientService.getIngredientById(id);
        if (existingIngredient.isPresent()) {
            ingredientService.deleteIngredient(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
