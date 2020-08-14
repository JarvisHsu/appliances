package cn.hellojarvis.service;

import cn.hellojarvis.entity.RequestPage;
import cn.hellojarvis.entity.UserAddress;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 23:09
 */
public interface IRequestPageService {
     List<UserAddress> loadUserAddress(Integer userId);
     public boolean createAnOrder(RequestPage requestPage);
     public UserAddress loadUserAddressById(Integer addrId);
     public RequestPage loadAnOrderByIds(Integer addrId,Integer goodsId,Integer userId);
     public List<RequestPage> loadUserOrders(Integer userId);
     public boolean updateOrderStatus(String status,Integer orderId);
     public RequestPage loadNewestOrder();
     public boolean addAComment(Integer orderId,String comment);
     public RequestPage loadAnOrderByOrderId(Integer orderId);
     public List<RequestPage> loadAllUsersOrdersWithRequesting();
     public int loadFixerOrders(Integer fixId);
     public boolean updateFixSend(RequestPage requestPage);
}
