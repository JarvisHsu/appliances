package cn.hellojarvis.service;

import cn.hellojarvis.entity.UserLogin;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/09 15:31
 */
public interface IUserLoginService {
    public boolean loadUser(UserLogin userLogin);
}
