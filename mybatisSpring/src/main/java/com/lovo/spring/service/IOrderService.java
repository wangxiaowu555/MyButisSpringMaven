package com.lovo.spring.service;

import com.lovo.spring.bean.OrderBean;

public interface IOrderService {
    /**
     * 添加订单
     * @param order 订单对象
     * @return 受影响行
     */
    boolean addOrder(OrderBean order);

    boolean updata(String name,int num);
}
