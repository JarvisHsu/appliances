package cn.hellojarvis.dao;

import cn.hellojarvis.entity.RequestPage;
import cn.hellojarvis.entity.UserAddress;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 22:31
 */
public interface IRequestPageDao {
    public List<UserAddress> loadUserAddress(Integer userId);
    public int createAnOrder(RequestPage requestPage);
    public UserAddress loadUserAddressById(Integer addrId);
    public RequestPage loadAnOrderByIds(Map<String,Integer> map);
    public List<RequestPage> loadUserOrders(Integer userId);
    public int updateOrderStatus(Map<String,Object> map);
    public RequestPage loadNewestOrder();
    public int addAComment(Map<String,Object> map);
    public RequestPage loadAnOrderByOrderId(Integer orderId);
    public List<RequestPage> loadAllUsersOrdersWithRequesting();
    public List<RequestPage> loadFixerOrders(Integer fixId);
    public int updateFixSend(RequestPage requestPage);
    public List<RequestPage> loadAllOrders();
}
