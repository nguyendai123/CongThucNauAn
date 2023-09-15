package com.example.congthucmonan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dishs")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DishID", nullable = false)
    private Long dishID;
    @Column(name = "DishName", length = 255, nullable = false)
    private String dishName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category", length = 20)
    private ECategory category;// mon chinh, mon phu, mon trang mieng
    @Column(name = "Cusine", length = 255, nullable = true)
    private String cusine;// am thuc Viet, trung quoc, y

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private Set<Recipe> recipes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "dish_ingredient",
            joinColumns = { @JoinColumn(name = "DishID") },
            inverseJoinColumns = { @JoinColumn(name = "IngredientID") })
    private Set< Ingredient > ingredients = new HashSet<>();

    public Set<Recipe> getRecipes() {
        return recipes;
    }
    public static List<Dish> findByIngredient(List<Dish> dishes, Ingredient ingredient) {
        List<Dish> matchingDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getIngredients().contains(ingredient)) {
                matchingDishes.add(dish);
            }
        }
        return matchingDishes;
    }
}
