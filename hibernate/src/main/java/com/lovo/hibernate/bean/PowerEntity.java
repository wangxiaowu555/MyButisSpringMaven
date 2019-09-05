package com.lovo.hibernate.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_power")
public class PowerEntity {
    @Id
    @GenericGenerator(name = "powerUuId",strategy = "uuid")
    @GeneratedValue(generator = "powerUuId")
    private String powerId;
    private String powerName;
    @OneToMany(mappedBy = "powerEntity")
    private List<RolaPowerEntity> rolaPowerEntityList;

    public List<RolaPowerEntity> getRolaPowerEntityList() {
        return rolaPowerEntityList;
    }

    public void setRolaPowerEntityList(List<RolaPowerEntity> rolaPowerEntityList) {
        this.rolaPowerEntityList = rolaPowerEntityList;
    }

    public String getPowerId() {
        return powerId;
    }

    public void setPowerId(String powerId) {
        this.powerId = powerId;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }
}
