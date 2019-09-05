import com.lovo.hibernate.bean.RolaEntity;
import com.lovo.hibernate.bean.UserEntity;
import com.lovo.hibernate.db.SessionDB;
import com.lovo.hibernate.dto.UserDto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SQL {
    Session session= null;
    @Before
    public  void before(){
        session= SessionDB.SessionOpen();
    }
    @Test
    public void sql(){
        String sql="select * from t_rola1";
        List<RolaEntity> list =
                session.createNativeQuery(sql)
                        .addEntity(RolaEntity.class)
                        .list();
        for (RolaEntity r: list) {
            System.out.println(r.getRolaName());
        }
    }
    @Test
    public void sql1(){
        String sql="select * from t_rola1 r left join t_userrole ur on r.id=ur.rolaId left join t_user1 u on u.id=ur.userId where u.userName=?";
        List<Object[]> list =
                session.createNativeQuery(sql)
                .setParameter(1,"hjk")
                .addEntity("u", UserEntity.class)
                .addEntity("r",RolaEntity.class)
                .list();
        for (Object[] obj: list ) {
            System.out.println(((UserEntity)obj[0]).getUserName());
            System.out.println(((RolaEntity)obj[1]).getRolaName());
        }
    }
    //如果不写addEntity，则是把数据放在集合里的
    @Test
    public void sql2(){
        String sql="select r.rolaName,u.userName from t_rola1 r left join t_userrole ur on r.id=ur.rolaId left join t_user1 u on u.id=ur.userId where u.userName=?";
        List<Object[]> list =
                session.createNativeQuery(sql)
                .setParameter(1, "hjk")
                .list();
        for (Object[] obj: list) {
            System.out.println(obj[0].toString());
            System.out.println(obj[1].toString());
        }
    }

    @Test
    public void sql3(){
        String sql="select r.rolaName,u.userName from t_rola1 r left join t_userrole ur on r.id=ur.rolaId left join t_user1 u on u.id=ur.userId where u.userName=?";
        List<Map<String,Object>> list =
                session.createNativeQuery(sql)
                .setParameter(1,"hjk")
                .unwrap(NativeQueryImpl.class)//拆包
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        for (Map<String,Object> map: list) {
            System.out.println(map.get("userName"));
            System.out.println(map.get("rolaName"));
        }
    }
    @Test
    public void sql4(){
        String sql="select u.userPwd,u.userName from t_rola1 r left join t_userrole ur on r.id=ur.rolaId left join t_user1 u on u.id=ur.userId where u.userName=?";
        List<UserDto> list =
                session.createNativeQuery(sql)
                        .setParameter(1, "hjk")
                        .unwrap(NativeQueryImpl.class)
                        .setResultTransformer(Transformers.aliasToBean(UserDto.class))
                        .list();
        for (UserDto dto:list) {
            System.out.println(dto.getUserName());
            System.out.println(dto.getUserPwd());
        }
    }
//    ------------------------------------------------------SQL分页---------------------------------------------
//     分页计算公式，起始位置：当前页-1*每页记录条数
    @Test
    public void sql5Page(){
        int dangQianYe = 1;//当前页
        int pageNum = 10;//每页显示的数据
        String sql="select * from t_user1";
        List<UserEntity> list = session.createNativeQuery(sql)
                .addEntity(UserEntity.class)
                .setFirstResult((dangQianYe - 1) * pageNum)
                .setMaxResults(pageNum)
                .list();
        for (UserEntity user: list
             ) {
            System.out.println(user.getUserName());
        }
    }
    @After
    public void after(){
        session.close();
    }
}
