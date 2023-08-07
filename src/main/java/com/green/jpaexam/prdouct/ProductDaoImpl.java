package com.green.jpaexam.prdouct;

import com.green.jpaexam.prdouct.model.ProductDto;
import com.green.jpaexam.prdouct.model.ProductEntity;
import com.green.jpaexam.prdouct.model.ProductRes;
import com.green.jpaexam.prdouct.model.ProductUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {
    private final ProductRepository rep;

    @Override // insert
    public ProductRes saveProduct(ProductEntity p) {
        ProductEntity result = rep.save(p);

        return ProductRes.builder()
        .name(result.getName())
        .stock(result.getStock())
        .price(result.getPrice())
        .createdAt(result.getCreatedAt())
        .build();
    }

    @Override // select
    public List<ProductRes> getProductAll() {
        List<ProductEntity> list = rep.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<ProductRes> result = list.stream().map(item -> ProductRes
                .builder()
                .number(item.getNumber())
                .name(item.getName())
                .price(item.getPrice())
                .stock(item.getStock())
                .createdAt(item.getCreatedAt())
                .build()
        ).toList();

        return result;
    }

    @Override // select ById
    public ProductRes getProduct(Long number) {
        Optional<ProductEntity> opt = rep.findById(number);
        if (!opt.isPresent()) {
            return null;
        }
        ProductEntity entity = opt.get();
        ProductRes result = ProductRes.builder()
                .number(entity.getNumber())
                .name(entity.getName())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .createdAt(entity.getCreatedAt())
                .build();

        return result;
    }

    @Override
    public ProductRes updProduct(ProductEntity p) {
        Optional<ProductEntity> opt = rep.findById(p.getNumber());
        if (!opt.isPresent()) {
            return null;
        }
        ProductEntity entity = opt.get();
        entity.setName(p.getName());
        entity.setPrice(p.getPrice());
        entity.setStock(p.getStock());
        ProductEntity result = rep.save(entity);
        return ProductRes.builder().number(result.getNumber())
                .name(result.getName())
                .price(result.getPrice())
                .stock(result.getStock())
                .build();
    }

    @Override
    public void delProduct(Long number) {
        rep.deleteById(number);
    }
}
