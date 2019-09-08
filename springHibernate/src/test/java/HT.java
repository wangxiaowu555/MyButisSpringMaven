import com.lovo.sh.dao.IUserDao;
import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class HT {

    ClassPathXmlApplicationContext app=null;
    @Before
    public void before(){
        app=new ClassPathXmlApplicationContext("springHibernate.xml");
    }
    @Test
    public void findUserList(){
        IUserService userService=(IUserService) app.getBean("userService");
    List<UserEntity> list= userService.findUserList();
        System.out.println(list.size());
    }
}
