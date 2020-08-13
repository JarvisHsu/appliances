package cn.hellojarvis.ServiceTest;

import cn.hellojarvis.service.impl.HaveGoodsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 22:03
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringRunner.class)
public class HaveGoodServiceTest {
    @Autowired
    private HaveGoodsServiceImpl haveGoodsService;

    @Test
    public void testLoadUserGoods(){
        haveGoodsService.loadUserGoods(1001).forEach(System.out::println);
    }
    @Test
    public void testLoadGoodsUsers(){
        haveGoodsService.loadGoodUsers(501).forEach(System.out::println);
    }

}
