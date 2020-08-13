package cn.hellojarvis.controller;

import cn.hellojarvis.entity.Goods;
import cn.hellojarvis.entity.RequestPage;
import cn.hellojarvis.entity.UserAddress;
import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.service.impl.GoodsServiceImpl;
import cn.hellojarvis.service.impl.HaveGoodsServiceImpl;
import cn.hellojarvis.service.impl.RequestPageServiceImpl;
import cn.hellojarvis.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 20:38
 * 进行客户的专有操作，请求订单，付费，以及评论
 */
@Controller("C_UserOperationController")
public class C_UserOperationController {
    @Autowired
    private RequestPageServiceImpl requestPageService;
    @Autowired
    private HaveGoodsServiceImpl haveGoodsService;
    @Autowired
    private UserInfoServiceImpl userInfoService;
    @Autowired
    private GoodsServiceImpl goodsService;

    @RequestMapping("/loadUserGoods")
    public ModelAndView loadUserGoods(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().removeAttribute("reqGoodsId");
        modelAndView.setViewName("index");
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        List<Goods> goodsList = haveGoodsService.loadUserGoods(userInfo.getUserId());
        if (goodsList != null) {
            request.setAttribute("goodsList", goodsList);
            modelAndView.setViewName("requestOrder(cUser)");
        }
        return modelAndView;
    }

    @RequestMapping("/loadUserAddress")
    public ModelAndView loadUserAddress(HttpServletRequest request) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        //产品id
        if (request.getParameter("0") != null) {
            request.getSession().setAttribute("reqGoodsId", request.getParameter("0"));
        }
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        List<UserAddress> userAddrList = requestPageService.loadUserAddress(userInfo.getUserId());
        if (userAddrList != null) {
            request.setAttribute("userAddrList", userAddrList);
            modelAndView.setViewName("requestOrder(cUser)");
        }
        return modelAndView;
    }

    @RequestMapping("/createOrder")
    public ModelAndView createOrder(HttpServletRequest request) {
        //地址Id
        Integer addrId = Integer.valueOf(request.getParameter("0"));
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        Integer userId = userInfo.getUserId();
        Integer goodsId = Integer.parseInt((String) request.getSession().getAttribute("reqGoodsId"));
        RequestPage requestPage = new RequestPage();
        requestPage.setGoodsId(goodsId);
        requestPage.setAddrId(addrId);
        requestPage.setUserId(userId);
        boolean bool = requestPageService.createAnOrder(requestPage);
        if (bool) {
            RequestPage order = requestPageService.loadAnOrderByIds(addrId, goodsId, userId);
            request.setAttribute("order", order);
            Goods goods = goodsService.loadGoodById(goodsId);
            request.setAttribute("goods", goods);
            UserAddress userAddress = requestPageService.loadUserAddressById(addrId);
            request.setAttribute("address", userAddress);
            System.out.println(goods);
            System.out.println(userAddress);
            System.out.println(order);
        } else {
            request.setAttribute("ErrorMessage", "订单创建失败");
        }
        return new ModelAndView("requestOrder(cUser)");
    }

    @RequestMapping("/cancelAnOrder")
    public ModelAndView cancelAnOrder(HttpServletRequest request) {
        String status = request.getParameter("0");
        Integer orderId = Integer.valueOf(request.getParameter("1"));
        boolean b = requestPageService.updateOrderStatus(status, orderId);
        return new ModelAndView("index");
    }
    @RequestMapping("/loadOrdersByUserId")
    public ModelAndView loadOrdersByUserId(HttpServletRequest request){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        Integer userId = userInfo.getUserId();
        List<RequestPage> requestPages = requestPageService.loadUserOrders(userId);
        requestPages.forEach(System.out::println);
        request.setAttribute("pageList",requestPages);
        return new ModelAndView("viewOrder");
    }

}
