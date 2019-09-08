package com.lovo.sh.service;

import com.lovo.sh.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    void savaProduct(ProductEntity product);
    List<ProductEntity> findByProductType(String type);
    int updateInTimeAndState(String num);
    List<ProductEntity> findByProductState(int state);
}
