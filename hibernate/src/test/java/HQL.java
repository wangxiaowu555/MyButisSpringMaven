import com.lovo.hibernate.bean.UserRolaEntity;
import com.lovo.hibernate.db.SessionDB;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HQL {
    Session session=null;
    @Before
    public void before(){
        session = SessionDB.SessionOpen();
    }
    @Test
    public void hql(){
        String hql="from UserRolaEntity ur where ur.userEntity.id=?";
        List<UserRolaEntity> list = session.createQuery(hql).setParameter(0, "ff8080816cfae00c016cfae00fe50000").list();
        for (UserRolaEntity ur: list) {
            System.out.println(ur.getRolaEntity().getRolaName());
        }
        session.close();
    }
}
