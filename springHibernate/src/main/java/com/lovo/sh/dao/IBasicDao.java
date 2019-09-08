package com.lovo.sh.dao;

import org.hibernate.Session;

public interface IBasicDao {
    /**
     * 获得一个session
     * @return
     */
    public Session openSession();
    /**
     * spring管理的session
     * @return
     */
    public Session currentSession();

}
