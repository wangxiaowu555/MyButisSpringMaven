package com.lovo.hibernate.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_rola1")
public class RolaEntity {
    @Id
    @GenericGenerator(name = "rolaUuId",strategy = "uuid")
    @GeneratedValue(generator = "rolaUuId")
    private String id;
    private String rolaName;
    private String rolaToString;
    @OneToMany(mappedBy = "rolaEntity")
    private List<UserRolaEntity> userRolaEntityList;
    @OneToMany(mappedBy = "rolaEntity")
    private List<RolaPowerEntity> rolaPowerEntityList;

    public List<RolaPowerEntity> getRolaPowerEntityList() {
        return rolaPowerEntityList;
    }

    public void setRolaPowerEntityList(List<RolaPowerEntity> rolaPowerEntityList) {
        this.rolaPowerEntityList = rolaPowerEntityList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRolaName() {
        return rolaName;
    }

    public void setRolaName(String rolaName) {
        this.rolaName = rolaName;
    }

    public String getRolaToString() {
        return rolaToString;
    }

    public void setRolaToString(String rolaToString) {
        this.rolaToString = rolaToString;
    }

    public List<UserRolaEntity> getUserRolaEntityList() {
        return userRolaEntityList;
    }

    public void setUserRolaEntityList(List<UserRolaEntity> userRolaEntityList) {
        this.userRolaEntityList = userRolaEntityList;
    }
}
