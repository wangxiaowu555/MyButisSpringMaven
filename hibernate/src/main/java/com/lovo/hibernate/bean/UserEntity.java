package com.lovo.hibernate.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user1")
public class UserEntity {
    @Id
    @GenericGenerator(name = "userUuId",strategy = "uuid")
    @GeneratedValue(generator = "userUuId")
    private String id;
    private String userName;
    private String userPwd;
    @OneToMany(mappedBy = "userEntity")
    private List<UserRolaEntity> userRolaEntityList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public List<UserRolaEntity> getUserRolaEntityList() {
        return userRolaEntityList;
    }

    public void setUserRolaEntityList(List<UserRolaEntity> userRolaEntityList) {
        this.userRolaEntityList = userRolaEntityList;
    }
}
