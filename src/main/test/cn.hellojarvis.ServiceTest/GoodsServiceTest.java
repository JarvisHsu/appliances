package cn.hellojarvis.ServiceTest;

import cn.hellojarvis.service.IGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 21:49
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringRunner.class)
public class GoodsServiceTest {
    @Autowired
    private IGoodsService goodsService;
    @Test
    public void testLoadGoodById(){
        System.out.println(goodsService.loadGoodById(501));
    }

}
