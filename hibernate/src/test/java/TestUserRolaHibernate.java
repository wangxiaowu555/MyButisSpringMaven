import com.lovo.hibernate.bean.RolaEntity;
import com.lovo.hibernate.bean.UserEntity;
import com.lovo.hibernate.bean.UserRolaEntity;
import com.lovo.hibernate.db.SessionDB;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestUserRolaHibernate {
    Session session=null;
    @Before
    public void before(){
        session = SessionDB.SessionOpen();
    }
    @Test
    public void t(){

    }
    @Test
    public void add(){
        Transaction transaction = session.getTransaction();
        transaction.begin();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("用户1");
        userEntity.setUserPwd("123");
        session.save(userEntity);
        RolaEntity rolaEntity = new RolaEntity();
        rolaEntity.setRolaName("角色1");
        rolaEntity.setRolaToString("详细说明");
        session.save(rolaEntity);
        for (int i = 0; i <5 ; i++) {
            UserRolaEntity userRolaEntity = new UserRolaEntity();
            userRolaEntity.setZhuangtai("状态"+i);
            userRolaEntity.setRolaEntity(rolaEntity);
            userRolaEntity.setUserEntity(userEntity);
            session.save(userRolaEntity);
        }
        transaction.commit();
        session.close();
    }
    @Test
    public void find(){
        UserEntity userEntity = session.get(UserEntity.class, "ff8080816cfae00c016cfae00fe50000");
        List<UserRolaEntity> userRolaEntityList = userEntity.getUserRolaEntityList();
        for (UserRolaEntity userRolaEntity: userRolaEntityList) {
            System.out.println(userRolaEntity.getRolaEntity().getRolaName()+"/"+userRolaEntity.getUserEntity().getUserName());
        }
        session.close();
    }
}
