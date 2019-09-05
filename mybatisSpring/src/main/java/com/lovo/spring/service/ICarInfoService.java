package com.lovo.spring.service;

import com.lovo.spring.bean.CarInfoBean;
import com.lovo.spring.bean.GarageBean;
import org.apache.ibatis.annotations.Param;

public interface ICarInfoService {
    //    显示车库空位
    int findNullStall();
    //    车辆进入车库
    boolean inCar(CarInfoBean carInfo);
    //    车辆离开车库
    boolean outCar(String outDate,long outTime,int price,int id);
    //    查询总价
    CarInfoBean findAll(String plateNumber);
}
