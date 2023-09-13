package com.example.congthucmonan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecipesID", nullable = false)
    private long recipesID;
    @Column(name = "RecipesName", length = 255, nullable = false)
    private String recipesName;
    @Column (name = "PreparationTimeMinutes")
    private int preparationTimeMinutes;//tg chuan bi
    @Column(name = "Equip", length = 255, nullable = false)
    private String equip;//chuan bi truoc khi nau mon an
    @Column(name = "Step", length = 255, nullable = true)
    private String step;// cac buoc nau
    @Column(name = "Image")
    private String image;//anh mon an theo cong thuc
    @Column(name = "Describe")
    private String describe;//mo ta cong thuc
    @Column (name = "CookingTimeMinutes")
    private int cookingTimeMinutes;// tg nau
    @Enumerated(EnumType.STRING)
    @Column
    private EDifficulty difficulty;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dishID")
    private Dish dish;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "recipe_ingredient",
            joinColumns = { @JoinColumn(name = "RecipesID") },
            inverseJoinColumns = { @JoinColumn(name = "IngredientID") })
    private Set< Ingredient > ingredients = new HashSet<>();
}
