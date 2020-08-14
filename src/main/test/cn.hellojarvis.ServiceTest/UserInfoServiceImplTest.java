package cn.hellojarvis.ServiceTest;

import cn.hellojarvis.service.impl.UserInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/09 14:05
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringRunner.class)
public class UserInfoServiceImplTest {
    @Autowired
    private UserInfoServiceImpl userInfoServiceImpl;

    @Test
    public void testLoadUserById(){
        Integer userId = 1001;
        System.out.println(userInfoServiceImpl.loadUserInfoById(userId));
    }
    @Test
    public void testLoadUserByRoleId(){
        Integer roleId = 3;
        System.out.println(userInfoServiceImpl.loadUserByRoleId(roleId));
    }
}
