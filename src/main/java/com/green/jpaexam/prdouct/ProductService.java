package com.green.jpaexam.prdouct;

import com.green.jpaexam.prdouct.model.ProductDto;
import com.green.jpaexam.prdouct.model.ProductEntity;
import com.green.jpaexam.prdouct.model.ProductRes;
import com.green.jpaexam.prdouct.model.ProductUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao dao;

    public ProductRes saveProduct (ProductDto dto) {
        ProductEntity entity = ProductEntity.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();
        return dao.saveProduct(entity);
    }

    public Page<ProductRes> getProductAll (Pageable page) {
        return dao.getProductAll(page);
    }

    public ProductRes getProduct (Long number) {
       return dao.getProduct(number);
    }

    public ProductRes updProduct(ProductUpdDto dto) {
        ProductEntity entity = ProductEntity.builder()
                .number(dto.getNumber())
                .stock(dto.getStock())
                .name(dto.getName())
                .price(dto.getPrice())
                .build();

        entity.setCreatedAt(LocalDateTime.now());
        return dao.updProduct(entity);
    }

    public void delProduct(Long number) {
        dao.delProduct(number);
    }
}
