package com.lovo.sh.dao;

import com.lovo.sh.entity.ProductEntity;
import com.lovo.sh.util.StringBlNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository("productDaoImpl")
public class ProductDaoImpl {
    @Autowired
    LocalContainerEntityManagerFactoryBean entityManagerFactory;
    public EntityManagerFactory getEntityManager(){
        return entityManagerFactory.getObject();
    }

    public List<ProductEntity> findByProductNameOrProductType(String name,String type){
        EntityManager entityManager = this.getEntityManager().createEntityManager();
        String hql="from ProductEntity where 1=1 ";
        if (StringBlNull.StringNullYesOrNo(name)) {
            hql+=" and productName ='"+name+"' ";
        }
        if (StringBlNull.StringNullYesOrNo(type)){
            hql+=" and productType ='"+type+"' ";
        }
        List<ProductEntity> list= entityManager.createQuery(hql).getResultList();
        return list;
    }
}
