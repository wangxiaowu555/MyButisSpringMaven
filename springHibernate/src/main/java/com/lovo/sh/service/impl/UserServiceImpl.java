package com.lovo.sh.service.impl;

import com.lovo.sh.dao.IUserDao;
import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Transactional(readOnly = true)
    @Override
    public List<UserEntity> findUserList() {
            return userDao.findUserList();
    }
}
