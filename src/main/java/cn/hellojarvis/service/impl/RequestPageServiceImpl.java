package cn.hellojarvis.service.impl;

import cn.hellojarvis.dao.IRequestPageDao;
import cn.hellojarvis.entity.RequestPage;
import cn.hellojarvis.entity.UserAddress;
import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.service.IRequestPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public boolean createAnOrder(RequestPage requestPage) {
        requestPage.setPrice(requestPage.getGoodsId() / 50 + Math.random() * 2);
        requestPage.setStatus("3");
        return requestPageDao.createAnOrder(requestPage) != 0;
    }

    @Override
    public UserAddress loadUserAddressById(Integer addrId) {
        return requestPageDao.loadUserAddressById(addrId);
    }

    @Override
    public RequestPage loadAnOrderByIds(Integer addrId, Integer goodsId, Integer userId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("addrId", addrId);
        map.put("goodsId", goodsId);
        map.put("userId", userId);
        return requestPageDao.loadAnOrderByIds(map);
    }

    @Override
    public List<RequestPage> loadUserOrders(Integer userId) {
        return requestPageDao.loadUserOrders(userId);
    }

    @Override
    public boolean updateOrderStatus(String status, Integer orderId) {
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        map.put("orderId",orderId);
        return requestPageDao.updateOrderStatus(map)!=0;
    }

    @Override
    public RequestPage loadNewestOrder() {
        return requestPageDao.loadNewestOrder();
    }

    @Override
    public boolean addAComment(Integer orderId, String comment) {
        Map<String,Object> map = new HashMap<>();
        map.put("orderId",orderId);
        map.put("comment",comment);
        return requestPageDao.addAComment(map)!=0;
    }
}
