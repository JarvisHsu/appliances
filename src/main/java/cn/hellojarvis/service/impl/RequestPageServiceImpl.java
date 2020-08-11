package cn.hellojarvis.service.impl;

import cn.hellojarvis.dao.IRequestPageDao;
import cn.hellojarvis.entity.UserAddress;
import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.service.IRequestPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 23:10
 */
@Service("RequestPageServiceImpl")
public class RequestPageServiceImpl implements IRequestPageService {
    @Autowired
    private IRequestPageDao requestPageDao;
    @Override
    public List<UserAddress> loadUserAddress(Integer userId) {
        return requestPageDao.loadUserAddress(userId);
    }
}
