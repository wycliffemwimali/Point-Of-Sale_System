package com.wycliffe.pointofsalesystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "stock")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stockId")
    private Long id;

    private String name;

    private Integer qty;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stockEntity", cascade = CascadeType.ALL)
    private List<ItemEntity> items;

}