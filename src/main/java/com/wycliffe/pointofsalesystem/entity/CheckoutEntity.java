package com.wycliffe.pointofsalesystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "checkout")
public class CheckoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkoutId")
    private Long id;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private LocalDateTime orderTime;

    @ManyToMany
    @JoinTable(
        name = "checkout_item",
        joinColumns = @JoinColumn(name = "checkoutId"),
        inverseJoinColumns = @JoinColumn(name = "itemId")
    )
    private Set<ItemEntity> items = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Set<ItemEntity> getItems() {
        return items;
    }

    public void setItems(Set<ItemEntity> items) {
        this.items = items;
    }
}