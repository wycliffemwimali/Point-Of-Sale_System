package com.wycliffe.pointofsalesystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private String name;
    private Double price;
    private Long categoryId;
    private Long stockId;
}