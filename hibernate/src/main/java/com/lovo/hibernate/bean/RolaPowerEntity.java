package com.lovo.hibernate.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_rolapower")
public class RolaPowerEntity {
    @Id
    @GenericGenerator(name = "rolaPowerUuId",strategy = "uuid")
    @GeneratedValue(generator = "rolaPowerUuId")
    private String id;
    @ManyToOne
    @JoinColumn(name="rolaId")
    private RolaEntity rolaEntity;
    @ManyToOne
    @JoinColumn(name="powerId")
    private PowerEntity powerEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RolaEntity getRolaEntity() {
        return rolaEntity;
    }

    public void setRolaEntity(RolaEntity rolaEntity) {
        this.rolaEntity = rolaEntity;
    }

    public PowerEntity getPowerEntity() {
        return powerEntity;
    }

    public void setPowerEntity(PowerEntity powerEntity) {
        this.powerEntity = powerEntity;
    }
}
