package com.lovo.sh.dao;

import com.lovo.sh.entity.UserEntity;

import java.util.List;

public interface IUserDao {

    public List<UserEntity> findUserList();
}
