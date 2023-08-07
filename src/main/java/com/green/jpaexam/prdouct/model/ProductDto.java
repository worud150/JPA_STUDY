package com.green.jpaexam.prdouct.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductDto {
    private final String name;
    private final int price;
    private final int stock;
    private final LocalDateTime createdAt;
}
