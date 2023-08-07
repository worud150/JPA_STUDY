package com.green.jpaexam.prdouct;

import com.green.jpaexam.prdouct.model.ProductDto;
import com.green.jpaexam.prdouct.model.ProductEntity;
import com.green.jpaexam.prdouct.model.ProductRes;
import com.green.jpaexam.prdouct.model.ProductUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                .createdAt(dto.getCreatedAt())
                .build();
        return dao.saveProduct(entity);
    }

    public List<ProductRes> getProductAll () {
        return dao.getProductAll();
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

        return dao.updProduct(entity);
    }

    public void delProduct(Long number) {
        dao.delProduct(number);
    }
}
