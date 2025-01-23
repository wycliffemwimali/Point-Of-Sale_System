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
}