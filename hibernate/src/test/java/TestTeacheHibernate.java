import com.lovo.hibernate.bean.StudentBean;
import com.lovo.hibernate.bean.TearcherBean;
import com.lovo.hibernate.db.SessionDB;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TypeHelper;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestTeacheHibernate {
    Session session=null;
    @Before
    public void before(){
        session = SessionDB.SessionOpen();
    }
    @Test
    public void addTeacher(){
        TearcherBean tearcher = new TearcherBean();
        tearcher.setTeaName("张无忌");
        tearcher.setTeaPassWord("123");
        tearcher.setTeaPost("语文老师");
        tearcher.setTeaPhone("13452012315");
        tearcher.setTeaAddress("红瓦寺1号");
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(tearcher);
        transaction.commit();
        session.close();
    }
    @Test
    public void findById(){
        TearcherBean tearcherBean = session.find(TearcherBean.class, "4028ab0f6cf65f1f016cf65f22960000");
        session.close();
        System.out.println(tearcherBean.getTeaName());
    }
    @Test
    public void delTeacher(){
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.delete(session.find(TearcherBean.class,"4028ab0f6cf65f1f016cf65f22960000"));
        transaction.commit();
        session.close();
    }
    //跟鬼一样，就是覆盖
    @Test
    public void update(){
        TearcherBean tearcher = new TearcherBean();
        tearcher.setTeaName("陈老师");
        tearcher.setTeaAddress("一环路");
        tearcher.setId("4028ab0f6cf665ca016cf665cd2a0000");
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(tearcher);
        transaction.commit();
        session.close();
    }
    @Test
    public void update1(){
        Transaction transaction = session.getTransaction();
        transaction.begin();
        TearcherBean tearcher = session.find(TearcherBean.class, "4028ab0f6cf669b0016cf669b36d0000");
        tearcher.setTeaName("五老师");
        tearcher.setTeaAddress("一环路");
        String str = "超级无敌宇宙美少女";
        for (int i = 0; i < 3; i++) {
            str += str;
        }
        tearcher.setTeaPost(str);

//        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//        String date= sdf.format(new Date());  这个是日期转换，这里用不到，以后可能能用上

        session.update(tearcher);
        transaction.commit();
        session.close();
    }
    @Test
    public void addManyToOne(){
        Transaction transaction = session.getTransaction();
        transaction.begin();
        TearcherBean tearcherBean = new TearcherBean();
        tearcherBean.setTeaName("张三丰");
        tearcherBean.setTeaPassWord("123");
        tearcherBean.setTeaPost("数学老师");
        tearcherBean.setTeaPhone("13888012315");
        tearcherBean.setTeaAddress("新南门");
        session.save(tearcherBean);

        for (int i = 0; i < 3; i++) {
            StudentBean studentBean = new StudentBean();
            studentBean.setPassword("123");
            studentBean.setScare(111);
            studentBean.setUserName("霍建华"+i);
            studentBean.setCoolOrChou("帅");
            studentBean.setTearcher(tearcherBean);
            session.save(studentBean);
        }

        transaction.commit();
        session.close();
    }
    @Test
    public void findManyToOne(){
        StudentBean studentBean = session.find(StudentBean.class, "4028ab0f6cfa2ab4016cfa2ab7270001");
        System.out.println(studentBean.getUserName()+"/"+studentBean.getTearcher().getTeaName());
        session.close();
    }
    @Test
    public void findOneToMany(){
        TearcherBean tearcherBean = session.find(TearcherBean.class, "4028ab0f6cfa2ab4016cfa2ab71a0000");
        System.out.println( tearcherBean.getTeaName());
        List<StudentBean> studentList = tearcherBean.getStudentList();
        for (StudentBean stu: studentList) {
            System.out.println(stu.getUserName());
        }
        session.close();
    }

}
