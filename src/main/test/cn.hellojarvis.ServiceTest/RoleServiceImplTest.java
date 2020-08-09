package cn.hellojarvis.ServiceTest;

import cn.hellojarvis.service.impl.RoleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/08 23:47
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringRunner.class)
public class RoleServiceImplTest {
    @Autowired
    private RoleServiceImpl roleService;
    @Test
    public void testGetAllRole(){
        roleService.getAllRole().forEach(System.out::println);
    }
    @Test
    public void testGetRoleByName(){
        System.out.println(roleService.getRoleByName("客户"));
    }

}
