import com.lovo.hibernate.db.SessionDB;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FindAllPowerTest {
    Session session= null;
    @Before
    public  void before() {
        session = SessionDB.SessionOpen();
    }
    @Test
    public void hql(){
        String hql="select p.powerName from UserRolaEntity ur left join ur.rolaEntity r left join r.rolaPowerEntityList rpl left join rpl.powerEntity p where ur.userEntity.userName = ? ";
        List<String> list = session.createQuery(hql).setParameter(0, "hjk").list();
        for (String str: list) {
            System.out.println(str);
        }
    }
    @Test
    public void sql(){
        String sql="select p.powerName from t_user1 u left join t_userrole ur on u.id=ur.userId left join t_rola1 r on r.id=ur.rolaId left join t_rolapower rp on r.id=rp.rolaId left join t_power p on p.powerId=rp.powerId where u.userName=?";
        List<String> list = session.createNativeQuery(sql).setParameter(1, "hjk")
                .list();
        for (String str:list
             ) {
            System.out.println(str.toString());
        }
    }
    @After
    public void after(){
        session.close();
    }
}
