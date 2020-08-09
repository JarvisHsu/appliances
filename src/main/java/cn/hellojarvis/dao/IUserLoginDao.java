package cn.hellojarvis.dao;

import cn.hellojarvis.entity.UserLogin;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/08 23:13
 */
public interface IUserLoginDao {
    public UserLogin loadUser(UserLogin userLogin);
}
