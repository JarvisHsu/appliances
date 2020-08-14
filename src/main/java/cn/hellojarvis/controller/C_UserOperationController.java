package cn.hellojarvis.controller;

import cn.hellojarvis.entity.*;
import cn.hellojarvis.service.*;
import cn.hellojarvis.service.impl.*;
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
    private IRequestPageService requestPageService;
    @Autowired
    private IHaveGoodService haveGoodsService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IPayAccountService payAccountService;

    @RequestMapping("/loadUserGoods")
    public ModelAndView loadUserGoods(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().removeAttribute("reqGoodsId");
        modelAndView.setViewName("index");
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        System.out.println(userInfo);
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
            RequestPage order = requestPageService.loadNewestOrder();
            request.setAttribute("order", order);
            Goods goods = goodsService.loadGoodById(goodsId);
            request.setAttribute("goods", goods);
            UserAddress userAddress = requestPageService.loadUserAddressById(addrId);
            request.setAttribute("address", userAddress);
        } else {
            request.setAttribute("ErrorMessage", "订单创建失败");
        }
        return new ModelAndView("requestOrder(cUser)");
    }

    @RequestMapping("/cancelAnOrder")
    public void cancelAnOrder(HttpServletRequest request,HttpServletResponse response,String status,Integer orderId) throws IOException {
        boolean b = requestPageService.updateOrderStatus(status, orderId);
        response.getWriter().print(b ?"true":"false");
        response.getWriter().flush();
    }

    @RequestMapping("/loadOrdersByUserId")
    public ModelAndView loadOrdersByUserId(HttpServletRequest request){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        Integer userId = userInfo.getUserId();
        System.out.println(userId);
        List<RequestPage> requestPages = requestPageService.loadUserOrders(userId);
        request.setAttribute("pageList",requestPages);
        System.out.println(requestPages);
        return new ModelAndView("viewOrder");
    }
    @RequestMapping("/addAComment")
    public ModelAndView addAComment(HttpServletRequest request){
        Integer orderId = Integer.valueOf(request.getParameter("0"));
        String comment = request.getParameter("1");
        boolean b = requestPageService.addAComment(orderId, comment);
        return new ModelAndView("redirect:loadOrdersByUserId");
    }

    @RequestMapping("/checkPayAccount")
    public void checkPayAccount(HttpServletRequest request, HttpServletResponse response, PayAccount payAccount,Integer orderId) throws IOException {
        PayAccount account = payAccountService.checkAccount(payAccount);
        RequestPage requestPage = requestPageService.loadAnOrderByOrderId(orderId);
        response.getWriter().print(account!=null?account.getBalance()+","+requestPage.getPrice():"0");
        response.getWriter().flush();
    }
    @RequestMapping("/payTheOrder")
    public ModelAndView payTheOrder(HttpServletRequest request){
        Integer orderId = Integer.valueOf(request.getParameter("0"));
        Double shouldPay = Double.valueOf(request.getParameter("1"));
        Integer userId = Integer.valueOf(request.getParameter("2"));
        Double lastMoney = Double.valueOf(request.getParameter("3"));
        if (lastMoney<shouldPay){
            request.setAttribute("payErrorMessage","账户余额不足");
        }else {

        }
        return new ModelAndView("viewOrder");
    }
}
