package cn.hellojarvis.dao;

import cn.hellojarvis.entity.UserAddress;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 22:31
 */
public interface IRequestPageDao {
    public List<UserAddress> loadUserAddress(Integer userId);
}
