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
}
