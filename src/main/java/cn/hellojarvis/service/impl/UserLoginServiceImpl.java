package cn.hellojarvis.service.impl;

import cn.hellojarvis.dao.IUserLoginDao;
import cn.hellojarvis.entity.UserLogin;
import cn.hellojarvis.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/08 23:17
 */
@Service("UserLoginServiceImpl")
public class UserLoginServiceImpl implements IUserLoginService {
    @Autowired
    private IUserLoginDao userLoginDao;

    @Override
    public boolean loadUser(UserLogin userLogin){
        return userLoginDao.loadUser(userLogin)!=null;
    }

    @Override
    public UserLogin loadNewestUser() {
        return userLoginDao.loadNewestUser();
    }

    @Override
    public boolean createUser() {
        return userLoginDao.createUser()!=0;
    }
}
