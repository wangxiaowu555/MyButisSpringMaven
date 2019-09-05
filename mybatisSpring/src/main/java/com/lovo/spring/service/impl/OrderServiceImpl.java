package com.lovo.spring.service.impl;

import com.lovo.spring.bean.OrderBean;
import com.lovo.spring.dao.IOrderDao;
import com.lovo.spring.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    @Override
    public boolean addOrder(OrderBean order) {
        boolean a = false;
        if (orderDao.addOrder(order) >0) {
            a = true;
            this.updata(order.getRepertory().getProductName(),order.getSellNum());
        }
        return a;
    }

    @Override
    public boolean updata(String name, int num) {
        boolean a = false;
        int t = 1/0;
        if (orderDao.updata(name,num) >0) {
            a = true;
        }
        return a;
    }
}
