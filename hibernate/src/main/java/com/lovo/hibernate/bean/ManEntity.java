package com.lovo.hibernate.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_man")
public class ManEntity {
    @Id
    @GenericGenerator(name = "manUuId",strategy = "uuid")
    @GeneratedValue(generator = "manUuId")
    @Column(name = "t_manId",length = 32)
    private String manId;
    @Column(name = "t_manName",length = 32)
    private String manName;
    //fetch = FetchType.LAZY的意思是给他设置为懒加载
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_carId")
    private CarEntity carEntity;

    public String getManId() {
        return manId;
    }

    public void setManId(String manId) {
        this.manId = manId;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }
}
