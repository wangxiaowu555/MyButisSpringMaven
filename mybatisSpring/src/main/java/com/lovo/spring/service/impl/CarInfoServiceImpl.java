package com.lovo.spring.service.impl;

import com.lovo.spring.bean.CarInfoBean;
import com.lovo.spring.bean.GarageBean;
import com.lovo.spring.dao.ICarInfoDao;
import com.lovo.spring.service.ICarInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carInfoService")
public class CarInfoServiceImpl implements ICarInfoService {
    @Autowired
    private ICarInfoDao carInfoDao;

    public int findNullStall() {
        return carInfoDao.findNullStall();
    }

    @Override
    public boolean inCar(CarInfoBean carInfo) {
        boolean a = false;
        if (carInfoDao.outCar(carInfo) >0) {
            a = true;
            carInfoDao.update(-1);
            try {
                Thread.sleep(220);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    @Override
    public boolean outCar(String outDate,long outTime,int price,int id) {
        boolean a = false;
        if (carInfoDao.updateTime(outDate,outTime,price,id) >0) {
            a = true;
            carInfoDao.update(1);
        }
        return a;
    }

    @Override
    public CarInfoBean findAll(String plateNumber) {
        return carInfoDao.findAll(plateNumber);
    }

}
