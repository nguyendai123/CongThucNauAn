package com.example.congthucmonan.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IngredientID", nullable = false)
    private long ingredientID;
    @Column(name = "IngredientName", length = 255, nullable = false)
    private String ingredientName;
    @Column(name = "Price", length = 25, nullable = false)
    private String price;
    @Column(name = "Source", length = 25, nullable = true)
    private String source;// nguon goc nguyen lieu
    @Column(name = "Unit", length = 25, nullable = false)
    private String unit;// don vi do

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },mappedBy = "ingredients")
    private Set<Recipe> recipes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },mappedBy = "ingredients")
    private Set<Dish> dishs = new HashSet<>();
}
