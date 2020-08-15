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

     /**
      * @param userId 客户Id
      * @return
      */
     List<UserAddress> loadUserAddress(Integer userId);

     /**
      * @param requestPage 订单
      * @return
      */
     public boolean createAnOrder(RequestPage requestPage);

     /**
      * @param addrId 地址Id
      * @return
      */
     public UserAddress loadUserAddressById(Integer addrId);

     /**
      * @param addrId 地址Id
      * @param goodsId 商品Id
      * @param userId 客户Id
      * @return
      */
     public RequestPage loadAnOrderByIds(Integer addrId,Integer goodsId,Integer userId);

     /**
      * @param userId 客户Id
      * @return
      */
     public List<RequestPage> loadUserOrders(Integer userId);

     /**
      * @param status 状态
      * @param orderId 订单Id
      * @return
      */
     public boolean updateOrderStatus(String status,Integer orderId);

     /**
      * @return 最新的单子
      */
     public RequestPage loadNewestOrder();

     /**
      * @param orderId 订单Id
      * @param comment 评论内容
      * @return
      */
     public boolean addAComment(Integer orderId,String comment);

     /**
      * @param orderId 订单Id
      * @return
      */
     public RequestPage loadAnOrderByOrderId(Integer orderId);

     /**
      * @return 所有没有废弃和支付的订单
      */
     public List<RequestPage> loadAllUsersOrdersWithRequesting();

     /**
      * @param fixId 技工Id
      * @return 技工当前的订单量
      */
     public int loadFixerOrdersNum(Integer fixId);

     /**
      * @param fixId 技工Id
      * @return
      */
     public List<RequestPage> loadFixerOrders(Integer fixId);
     /**
      * @param requestPage 订单
      * @return
      */
     public boolean updateFixSend(RequestPage requestPage);
     public List<RequestPage> loadAllOrders();
}
