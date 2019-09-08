package com.lovo.sh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_rola2")
public class RolaEntity {
    @Id
    @GenericGenerator(name = "rolaUuId",strategy = "uuid")
    @GeneratedValue(generator = "rolaUuId")
    private String id;
    private String rolaName;
    private String rolaToString;
    @ManyToMany(mappedBy = "rolaEntityList")
    private List<UserEntity> userEntityList;

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
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
}
