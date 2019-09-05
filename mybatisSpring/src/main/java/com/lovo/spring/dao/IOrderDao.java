package com.lovo.spring.dao;

import com.lovo.spring.bean.OrderBean;

public interface IOrderDao {
    /**
     * 添加订单
     * @param order 订单对象
     * @return 受影响行
     */
    int addOrder(OrderBean order);

    int updata(String name,int num);
}
