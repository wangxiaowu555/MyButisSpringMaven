package com.lovo.sh.dao;

import com.lovo.sh.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductDao extends CrudRepository<ProductEntity,String> {
    List<ProductEntity> findByProductType(String type);
    List<ProductEntity> findByProductState(int state);
}
