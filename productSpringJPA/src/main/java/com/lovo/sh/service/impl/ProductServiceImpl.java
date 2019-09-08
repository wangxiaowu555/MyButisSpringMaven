package com.lovo.sh.service.impl;

import com.lovo.sh.dao.IProductDao;
import com.lovo.sh.entity.ProductEntity;
import com.lovo.sh.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service(value = "productService")
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public void savaProduct(ProductEntity product) {
        productDao.save(product);
    }

    @Override
    public List<ProductEntity> findByProductType(String type) {
        return productDao.findByProductType(type);
    }

    @Override
    public int updateInTimeAndState(String num) {
        ProductEntity one = productDao.findOne(num);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateformat.format(System.currentTimeMillis());
        one.setProductInTime(dateStr);
        one.setProductState(0);
        ProductEntity save = productDao.save(one);
        if (save !=null){
            return 1;
        }
        return 0;
    }

    @Override
    public List<ProductEntity> findByProductState(int state) {
        return productDao.findByProductState(state);
    }

}
