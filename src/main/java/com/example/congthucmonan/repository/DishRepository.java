package com.example.congthucmonan.repository;

import com.example.congthucmonan.model.Dish;
import com.example.congthucmonan.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findByDishName(String name);

    List<Dish> findByCategory(String categories);



    List<Dish> findByIngredients(String ingredient);
    List<Dish> findByIngredientsIn(List<Ingredient> ingredients);


}
