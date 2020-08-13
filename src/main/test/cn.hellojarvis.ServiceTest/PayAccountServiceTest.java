package cn.hellojarvis.ServiceTest;

import cn.hellojarvis.entity.PayAccount;
import cn.hellojarvis.service.IPayAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/13 23:58
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringRunner.class)
public class PayAccountServiceTest {
    @Autowired
    private IPayAccountService payAccountService;
    @Test
    public void testLoadAccount(){
        PayAccount payAccount = new PayAccount();
        payAccount.setUserId(1001);
        payAccount.setPayPwd("123456");
        System.out.println(payAccountService.checkAccount(payAccount));
    }
}
