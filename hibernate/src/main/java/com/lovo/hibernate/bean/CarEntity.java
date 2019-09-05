package com.lovo.hibernate.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_car")
public class CarEntity {
    @Id
    @GenericGenerator(name = "carUuId",strategy = "uuid" )
    @GeneratedValue(generator = "carUuId")
    @Column(name = "t_carId",length =32)
    private String carId;
    @Column(name = "t_carName",length = 32)
    private String carName;
    //fetch = FetchType.EAGER的意思是给他设置为急加载
    @OneToMany(mappedBy = "carEntity",fetch = FetchType.EAGER)
    private List<ManEntity> manEntityList;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public List<ManEntity> getManEntityList() {
        return manEntityList;
    }

    public void setManEntityList(List<ManEntity> manEntityList) {
        this.manEntityList = manEntityList;
    }
}
