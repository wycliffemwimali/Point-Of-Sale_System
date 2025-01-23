package com.wycliffe.pointofsalesystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "item")
public class ItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonBackReference
    private CategoryEntity categoryEntity;


    @ManyToOne
    @JoinColumn(name = "stockId")
    @JsonBackReference
    private StockEntity stockEntity;

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private Set<CheckoutEntity> checkouts = new HashSet<>();
}