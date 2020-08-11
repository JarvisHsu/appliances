package cn.hellojarvis.service.impl;

import cn.hellojarvis.dao.IUserInfoDao;
import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/08 23:16
 */
@Service("UserInfoServiceImpl")
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private IUserInfoDao userInfoDao;

    @Override
    public UserInfo loadUserInfoById(Integer userId) {
        return userInfoDao.getUserInfo(userId);
    }

    @Override
    public boolean modifyUserInfo(UserInfo userInfo) {
        return userInfoDao.modifyUserInfo(userInfo);
    }
}