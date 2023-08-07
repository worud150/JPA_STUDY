package com.green.jpaexam.prdouct;

import com.green.jpaexam.prdouct.model.ProductEntity;
import com.green.jpaexam.prdouct.model.ProductRes;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    ProductRes saveProduct (ProductEntity p);
    List<ProductRes> getProductAll();
    ProductRes getProduct (Long number);
    ProductRes updProduct(ProductEntity entity);
    void delProduct (Long number);
}
