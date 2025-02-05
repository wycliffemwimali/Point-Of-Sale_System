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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public StockEntity getStockEntity() {
        return stockEntity;
    }

    public void setStockEntity(StockEntity stockEntity) {
        this.stockEntity = stockEntity;
    }

    public Set<CheckoutEntity> getCheckouts() {
        return checkouts;
    }

    public void setCheckouts(Set<CheckoutEntity> checkouts) {
        this.checkouts = checkouts;
    }
}