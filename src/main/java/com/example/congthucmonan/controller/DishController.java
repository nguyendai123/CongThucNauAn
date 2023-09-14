package com.example.congthucmonan.controller;

import com.example.congthucmonan.model.Dish;
import com.example.congthucmonan.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }
//    @Autowired
//
//    private RecipeRepository recipeRepository;
//
//    @Autowired
//    private DishRepository dishRepository;
    @GetMapping
    public List<Dish> getAllDishs() {
        return dishService.getAllDishes();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable("id") Long id) {
        Optional<Dish> dish = dishService.getDishById(id);
        return dish.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Dish>> getDishByName(@PathVariable("name") String name) {
        List<Dish> dishs = dishService.getDishByName(name);
        if (dishs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(dishs);
        }
    }
    @GetMapping("/ingredient/{ingredient}")
    public ResponseEntity<List<Dish>> getDishesByIngredient(@PathVariable("ingredient") String ingredient) {
        List<Dish> dishes = dishService.getDishesByIngredient(ingredient);
        if (!dishes.isEmpty()) {
            return ResponseEntity.ok(dishes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/findByCategories")
    public ResponseEntity<List<Dish>> findDishsByCategories(@RequestParam("categories") String categories) {
        List<Dish> dishs = dishService.findByCategories(categories);
        if (dishs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(dishs);
        }
    }
    @PostMapping
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        Dish createdDish = dishService.createDish(dish);
        return ResponseEntity.ok(createdDish);
    }
//    @PostMapping("/recipes/{RecipeID}/dishs")
//    public ResponseEntity<Dish> addDish(@PathVariable(value = "RecipeID") Long recipeID, @RequestBody Dish dishRequest) {
//        Dish dish = recipeRepository.findById(recipeID).map(recipe -> {
//            long dishID = dishRequest.getDishID();
//
//            // tag is existed
//            if (dishID != 0L) {
//                Dish _dish = dishRepository.findById(dishID)
//                        .orElseThrow(() -> new ResourceNotFoundException("Not found Tag with id = " + dishID));
//                recipe.addDish(_dish);
//                recipeRepository.save(recipe);
//                return _dish;
//            }
//
//            // add and create new Tag
//            recipe.addDish(dishRequest);
//            return dishRepository.save(dishRequest);
//        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + recipeID));
//
//        return new ResponseEntity<>(dish, HttpStatus.CREATED);
//    }
    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable("id") Long id, @RequestBody Dish dish) {
        Optional<Dish> existingDish = dishService.getDishById(id);
        if (existingDish.isPresent()) {
            dish.setDishID(id);
            Dish updatedDish = dishService.updateDish(dish);
            return ResponseEntity.ok(updatedDish);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable("id") Long id) {
        Optional<Dish> existingDish = dishService.getDishById(id);
        if (existingDish.isPresent()) {
            dishService.deleteDish(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
