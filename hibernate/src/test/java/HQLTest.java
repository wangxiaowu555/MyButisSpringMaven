import com.lovo.hibernate.bean.RolaEntity;
import com.lovo.hibernate.bean.UserEntity;
import com.lovo.hibernate.bean.UserRolaEntity;
import com.lovo.hibernate.db.SessionDB;
import com.lovo.hibernate.dto.UserDto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class HQLTest {
    Session session= null;
    Transaction tx=null;
    @Before
    public  void before(){
        session= SessionDB.SessionOpen();
        tx= session.getTransaction();
        tx.begin();
    }
//    -------------------------------------------------登录作业9-4---------------------------------------------------
    public List<UserRolaEntity>  login(String userName, String userPwd){
        String hql = "from UserEntity u where userName=? and userPwd=?";
        UserEntity user = (UserEntity) session.createQuery(hql).setParameter(0, userName).setParameter(1, userPwd).uniqueResult();
        if (user !=null){
            System.out.println("登录成功");
            return user.getUserRolaEntityList();
        }
        else{
            System.out.println("登录失败");
            return null;
        }
    }
    public String findRolaName(String rolaName,List<UserRolaEntity> list){
        for (UserRolaEntity ur: list) {
            if (ur.getRolaEntity().getRolaName().equals(rolaName)) {
                return "欢迎"+ur.getRolaEntity().getRolaName()+"角色登录系统";
            }
        }
        return "非法登录";
    }
    @Test
    public void loginTest(){
        List<UserRolaEntity> list = this.login("hjk", "123");
        System.out.println(this.findRolaName("2",list));
    }

//    -------------------------------------------查询单个数据9-5--------------------------------------------
//    原生态
    @Test
    public void hql(){
        String hql="select userName,userPwd from UserEntity";
        List<Object[]> list = session.createQuery(hql).list();
        for (Object[] obj: list) {
            System.out.println(obj[0]+"/"+obj[1]);
        }
    }

    //使用DTO
    @Test
    public void hql1(){
        String hql="select new com.lovo.hibernate.dto.UserDto(userName,userPwd) from UserEntity";
        List<UserDto> list = session.createQuery(hql).list();
        System.out.println(list.get(0).getUserName()+"/"+list.get(0).getUserPwd());
    }

    //使用MAP集合
    @Test
    public void hql2(){
        String hql = "select new map(userName,userPwd) from UserEntity";
        List<Map<String,Object>> list = session.createQuery(hql).list();
        System.out.println(list.get(0).get("0")+"/"+list.get(0).get("1"));
        }

    @Test
    public void hql3(){
        String hql="select r.rolaName from UserRolaEntity ur left join ur.rolaEntity r where ur.userEntity.userName =?";
        List<String> list = session.createQuery(hql).setParameter(0, "hjk").list();
        for (String str :list) {
            System.out.println(str);
        }
    }
//    ----------------------------------------------HQL分页-------------------------------------------
    @Test
    public  void hql4Page(){
        int dangQianYe = 1;//当前页
        int pageNum = 10;//每页显示的数据
        String hql="from UserEntity";
        List<UserEntity> list= session.createQuery(hql)
                .setFirstResult((dangQianYe - 1) * pageNum)
                .setMaxResults(pageNum)
                .list();
        for (UserEntity user:list
             ) {
            System.out.println(user.getUserName());
        }
    }

    @After
    public void after(){
        tx.commit();
        session.close();
    }
}
