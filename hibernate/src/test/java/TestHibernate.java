import com.lovo.hibernate.bean.StudentBean;
import com.lovo.hibernate.db.SessionDB;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TestHibernate {
    @Test
    public void TestSession(){
        Session s = SessionDB.SessionOpen();
        System.out.println(s);
    }
    @Test
    public void add(){
        //瞬时状态
        StudentBean s = new StudentBean();
        s.setPassword("123");
        s.setScare(111);
        s.setUserName("刘德华");
        s.setCoolOrChou("没有我帅");
        Session a = SessionDB.SessionOpen();
        //得到事务
        Transaction transaction = a.getTransaction();
        //开启事务
        transaction.begin();
        //操作对象
        a.save(s);
//        s是持久状态

//        事务提交
        transaction.commit();
        a.close();

        //s是游离状态
    }
    @Test
    public void findById(){
        Session a = SessionDB.SessionOpen();
        StudentBean studentBean = a.find(StudentBean.class, "4028ab0f6cf63fbb016cf63fbdc90000");
        a.close();
        System.out.println(studentBean.getUserName());
    }

}
