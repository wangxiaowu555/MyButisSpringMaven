package com.lovo.sh.service;

import com.lovo.sh.entity.UserEntity;

import java.util.List;

public interface IUserService {
    public List<UserEntity> findUserList();
}
