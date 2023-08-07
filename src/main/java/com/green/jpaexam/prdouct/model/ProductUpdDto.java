package com.green.jpaexam.prdouct.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Locale;

@Data
public class ProductUpdDto {
    private Long number;
    private String name;
    private int price;
    private int stock;
    private LocalDate updatedAt;
}
