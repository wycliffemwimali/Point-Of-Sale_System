package com.wycliffe.pointofsalesystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CheckoutDto {
    List<Long> items;
}