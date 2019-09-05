import com.lovo.spring.bean.CarInfoBean;
import com.lovo.spring.bean.OrderBean;
import com.lovo.spring.bean.RepertoryBean;
import com.lovo.spring.service.ICarInfoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TCar {
    ClassPathXmlApplicationContext app=null;
    ICarInfoService service = null;
    @Before
    public void  before(){
        app=new ClassPathXmlApplicationContext("mybatisSpring.xml");
        service=   (ICarInfoService)app.getBean("carInfoService");
    }
    @Test
    public  void  testServcie(){
        System.out.println("当前剩余车位："+service.findNullStall());
        boolean a = service.inCar(new CarInfoBean("001","2019-09-02","",System.currentTimeMillis(),0,0));
        if (a == true) {
            System.out.println("停车成功！当前车位："+service.findNullStall());
        }
        boolean v = service.outCar("2019-09-02",System.currentTimeMillis(),1,1);
        if (v == true) {
            System.out.println("出库成功！当前车位："+service.findNullStall()+"费用为："+service.findAll("001").getStopMoney());
        }
    }
}
