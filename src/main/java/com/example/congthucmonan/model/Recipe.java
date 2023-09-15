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
    private Long recipesID;
    @Column(name = "RecipesName", length = 255, nullable = false)
    private String recipesName;
    @Column (name = "PreparationTimeMinutes")
    private Integer preparationTimeMinutes;//tg chuan bi
    @Column(name = "Equip", length = 255, nullable = false)
    private String equip;//chuan bi truoc khi nau mon an
    @Column(name = "Step", length = 255, nullable = true)
    private String step;// cac buoc nau
    @Column(name = "Image")
    private String image;//anh mon an theo cong thuc
    @Column(name = "RecipeDescription",length = 255, nullable = true)
    private String recipeDescription;//mo ta cong thuc
    @Column (name = "CookingTimeMinutes")
    private Integer cookingTimeMinutes;// tg nau

    @Enumerated(EnumType.STRING)
    @Column(name = "Difficulty", length = 20)

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

    public void addDish(Dish dish) {
        this.dish = dish;
        dish.getRecipes().add(this);
    }
}
