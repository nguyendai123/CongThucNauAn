package com.example.congthucmonan.service;

import com.example.congthucmonan.model.Dish;
import com.example.congthucmonan.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }


    public Optional<Dish> getDishById(Long dishId) {
        return dishRepository.findById(dishId);
    }

    public List<Dish> getDishByName(String dishName) {
        return dishRepository.findByDishName(dishName);
    }

    public List<Dish> findByCategories(String categories) {
        return dishRepository.findByCategory(categories);
    }





    public List<Dish> getDishesByIngredient(String ingredient) {
        return dishRepository.findByIngredients(ingredient);
    }

    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Dish updateDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public void deleteDish(Long dishId) {
        dishRepository.deleteById(dishId);
    }
}
