package com.green.jpaexam.prdouct.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ProductRes {
    private Long number;
    private String name;
    private int price;
    private int stock;
    private LocalDateTime createdAt;
}
