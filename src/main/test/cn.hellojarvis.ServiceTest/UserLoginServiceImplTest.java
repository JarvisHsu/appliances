package cn.hellojarvis.ServiceTest;

import cn.hellojarvis.entity.UserLogin;
import cn.hellojarvis.service.impl.UserLoginServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/09 00:03
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringRunner.class)
public class UserLoginServiceImplTest {
    @Autowired
    private UserLoginServiceImpl userLoginServiceImpl;
    @Test
    public void testLoadUser(){
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(1001);
        userLogin.setUserPwd("123");
        System.out.println(userLoginServiceImpl.loadUser(userLogin));
    }


}
