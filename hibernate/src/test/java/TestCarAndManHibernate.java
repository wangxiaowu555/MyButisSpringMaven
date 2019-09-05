import com.lovo.hibernate.bean.CarEntity;
import com.lovo.hibernate.bean.ManEntity;
import com.lovo.hibernate.db.SessionDB;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestCarAndManHibernate {
    Session session=null;
    @Before
    public void before(){
        session = SessionDB.SessionOpen();
    }
    @Test
    public void add(){
        Transaction transaction = session.getTransaction();
        transaction.begin();
        CarEntity carEntity = new CarEntity();
        carEntity.setCarName("雷克萨斯");
        session.save(carEntity);
        for (int i = 0; i <3 ; i++) {
            ManEntity manEntity = new ManEntity();
            manEntity.setManName("霍建华");
            manEntity.setCarEntity(carEntity);
            session.save(manEntity);
        }
        transaction.commit();
        session.close();
    }
    @Test
    public void findByManyToOne(){
        ManEntity manEntity = session.find(ManEntity.class, "4028ab0f6cfa3d12016cfa3d15ac0001");
        System.out.println(manEntity.getManName()+"/"+manEntity.getCarEntity().getCarName());
        session.close();
    }
    @Test
    public void findByOneToMany(){
        CarEntity carEntity = session.find(CarEntity.class, "4028ab0f6cfa3d12016cfa3d159d0000");

        System.out.println(carEntity.getCarName());
        List<ManEntity> manEntityList = carEntity.getManEntityList();
        for (ManEntity man: manEntityList ) {
            System.out.println(man.getManName());
        }
        session.close();
    }
}
