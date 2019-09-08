
import com.lovo.sh.entity.ProductEntity;
import com.lovo.sh.service.IProductService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.Table;
import java.util.List;


public class ProductTest {
    ClassPathXmlApplicationContext app=null;
    @Before
    public void before(){
        app=new ClassPathXmlApplicationContext("productSpringJPA.xml");
    }
    @Test
    public void test(){

    }
    @Test
    public void sava(){
        IProductService productService = (IProductService) app.getBean("productService");
        ProductEntity product=new ProductEntity();
        product.setProductType("类型1");
        product.setProductNum("编号1");
        product.setProductName("名字1");
        product.setProductInPrice(1);
        product.setProductOutPrice(2);
        productService.savaProduct(product);
    }

    @Test
    public void findByProductType(){
        IProductService productService = (IProductService) app.getBean("productService");
        List<ProductEntity> s = productService.findByProductType("类型1");
        System.out.println(s.size());
    }

    @Test
    public void update(){
        IProductService productService = (IProductService) app.getBean("productService");
        int i = productService.updateInTimeAndState("402881876d10a20b016d10a2126a0000");
        System.out.println(i);
    }

    @Test
    public void findByProductState(){
        IProductService productService = (IProductService) app.getBean("productService");
        List<ProductEntity> list = productService.findByProductState(1);
        for (ProductEntity pro: list) {
            System.out.println(pro.getProductName());
        }

    }
}
