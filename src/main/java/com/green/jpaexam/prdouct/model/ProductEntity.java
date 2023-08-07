package com.green.jpaexam.prdouct.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Table(name = "t_product")
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id // pk값임
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
