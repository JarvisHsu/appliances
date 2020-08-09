package cn.hellojarvis.dao;

import cn.hellojarvis.entity.UserInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/08 23:13
 */
public interface IUserInfoDao {
    public UserInfo getUserInfo(Integer userId);
    public boolean modifyUserInfo(UserInfo userInfo);
}
