package com.lovo.sh.dao.impl;

import com.lovo.sh.dao.IBasicDao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository(value = "basicDao")
public class BasicDaoImpl implements IBasicDao {

    //注入工厂bean
    @Autowired
    private LocalSessionFactoryBean factoryBean;

    public Session openSession() {
        return factoryBean.getObject().openSession();
    }

    @Override
    public Session currentSession() {
        return factoryBean.getObject().getCurrentSession();
    }
}
