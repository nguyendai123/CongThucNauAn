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
@Table(name = "dishs")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DishID", nullable = false)
    private long dishID;
    @Column(name = "DishName", length = 255, nullable = false)
    private String dishName;
    @Column(name = "Category", length = 25, nullable = true)
    @Enumerated(EnumType.STRING)
    private ECategory category;// mon chinh, mon phu, mon trang mieng
    @Column(name = "Cusine", length = 25, nullable = true)
    private String cusine;// am thuc Viet, trung quoc, y
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private Set<Dish> dishs;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "dish_ingredient",
            joinColumns = { @JoinColumn(name = "DishID") },
            inverseJoinColumns = { @JoinColumn(name = "IngredientID") })
    private Set< Ingredient > ingredients = new HashSet<>();
}
