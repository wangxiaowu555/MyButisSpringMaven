package com.lovo.spring.dao;

import com.lovo.spring.bean.CarInfoBean;
import com.lovo.spring.bean.GarageBean;
import org.apache.ibatis.annotations.Param;

public interface ICarInfoDao {
    //    显示车库空位
    int findNullStall();
    //    添加订单
    int outCar(CarInfoBean carInfo);
    //    修改订单信息
    int updateTime(String outDate,long outTime,int price,int id);
    //    修改车库空位数量
    int update(int newNum);

    CarInfoBean findAll(String plateNumber);
}
