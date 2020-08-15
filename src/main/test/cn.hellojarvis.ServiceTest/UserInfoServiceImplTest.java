package cn.hellojarvis.ServiceTest;

import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.entity.UserLogin;
import cn.hellojarvis.service.IUserInfoService;
import cn.hellojarvis.service.IUserLoginService;
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
    private IUserInfoService userInfoService;
    @Autowired
    private IUserLoginService userLoginService;

    @Test
    public void testLoadUserById(){
        Integer userId = 1001;
        System.out.println(userInfoService.loadUserInfoById(userId));
    }
    @Test
    public void testLoadUserByRoleId(){
        Integer roleId = 3;
        System.out.println(userInfoService.loadUserByRoleId(roleId));
    }
    @Test
    public void testCreateUser(){
        if (userLoginService.createUser()){
            UserLogin userLogin = userLoginService.loadNewestUser();
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userLogin.getUserId());
            userInfo.setRoleId(1);
            userInfo.setUserName("未启用");
            userInfoService.createAnUser(userInfo);
            System.out.println(userInfoService.loadUserInfoById(userLogin.getUserId()));
        }
    }

}
