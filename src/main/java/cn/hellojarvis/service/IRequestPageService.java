package cn.hellojarvis.service;

import cn.hellojarvis.entity.UserAddress;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 23:09
 */
public interface IRequestPageService {
     List<UserAddress> loadUserAddress(Integer userId);
}
