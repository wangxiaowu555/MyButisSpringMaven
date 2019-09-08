package com.lovo.sh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user2")
public class UserEntity {
    @Id
    @GenericGenerator(name = "uuuuid",strategy = "uuid")
    @GeneratedValue(generator = "uuuuid")
    @Column(length = 32,name = "u_id")
    private  String userId;
    @Column(length = 48)
    private String userName;
    @Column(length = 48)
    private String password;

    @ManyToMany
    @JoinTable(name = "t_userRola2",joinColumns = {@JoinColumn(name = "u_id")}
    ,inverseJoinColumns = {@JoinColumn(name = "r_id")})
    List<RolaEntity> rolaEntityList;

    public List<RolaEntity> getRolaEntityList() {
        return rolaEntityList;
    }

    public void setRolaEntityList(List<RolaEntity> rolaEntityList) {
        this.rolaEntityList = rolaEntityList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
