package com.lovo.hibernate.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_userRole")
public class UserRolaEntity {
    @Id
    @GenericGenerator(name = "userRolaUuId",strategy = "uuid")
    @GeneratedValue(generator = "userRolaUuId")
    private String id;
    private String zhuangtai;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "rolaId")
    private RolaEntity rolaEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public RolaEntity getRolaEntity() {
        return rolaEntity;
    }

    public void setRolaEntity(RolaEntity rolaEntity) {
        this.rolaEntity = rolaEntity;
    }
}
