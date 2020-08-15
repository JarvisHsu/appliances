package cn.hellojarvis.service;

import cn.hellojarvis.entity.UserInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/09 15:32
 */
public interface IUserInfoService {
    public boolean modifyUserInfo(UserInfo userInfo);
    public UserInfo loadUserInfoById(Integer userId);
    public List<UserInfo> loadUserByRoleId(Integer roleId);
    public boolean createAnUser(UserInfo userInfo);
}
