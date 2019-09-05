
import com.lovo.spring.bean.OrderBean;
import com.lovo.spring.bean.RepertoryBean;
import com.lovo.spring.service.IOrderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class T {
    ClassPathXmlApplicationContext app=null;
    IOrderService service = null;
    @Before
    public void  before(){
        app=new ClassPathXmlApplicationContext("mybatisSpring.xml");
        service=   (IOrderService)app.getBean("orderService");
    }
    @Test
    public  void  testServcie(){
        boolean a  = service.addOrder(new OrderBean(10,2,new RepertoryBean(1,"娃哈哈"),800));
        System.out.println(a);
    }
}
