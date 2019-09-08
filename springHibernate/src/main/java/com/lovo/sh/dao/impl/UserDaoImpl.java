package com.lovo.sh.dao.impl;

import com.lovo.sh.dao.IBasicDao;
import com.lovo.sh.dao.IUserDao;
import com.lovo.sh.entity.RolaEntity;
import com.lovo.sh.entity.UserEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
public class UserDaoImpl implements IUserDao {
    @Autowired
    private IBasicDao basicDao;

    public List<UserEntity> findUserList() {
     Session session= basicDao.openSession();
    List<UserEntity> list= session.createQuery("from UserEntity").list();
        for (UserEntity user:list){
            List<RolaEntity> listr= user.getRolaEntityList();
            for (RolaEntity r:listr){
                System.out.println(r.getRolaName());
            }
        }
     session.close();
        return list;
    }
}
