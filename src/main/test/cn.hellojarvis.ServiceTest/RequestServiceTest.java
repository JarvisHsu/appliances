package cn.hellojarvis.ServiceTest;

import cn.hellojarvis.service.IRequestPageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 23:11
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringRunner.class)
public class RequestServiceTest {
    @Autowired
    private IRequestPageService requestPageService;
    @Test
    public void testLoadUserAddress(){
        requestPageService.loadUserAddress(1001).forEach(System.out::println);
    }
    @Test
    public void testLoadAnOrder(){
        System.out.println(requestPageService.loadAnOrderByIds(1002, 503, 1001));

    }
    @Test
    public void testUpdateOrderStatus(){
        System.out.println(requestPageService.updateOrderStatus("1", 2));
    }
    @Test
    public void testLoadUserOrders(){
        requestPageService.loadUserOrders(1001).forEach(System.out::println);
    }
    @Test
    public void testAddAComment(){
        requestPageService.addAComment(1,"你好，我是客户1");
    }
    @Test
    public void testLoadFixerOrders(){
        System.out.println(requestPageService.loadFixerOrdersNum(1003));
        requestPageService.loadFixerOrders(1003).forEach(System.out::println);
    }
}
