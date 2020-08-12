package cn.hellojarvis.controller;

import cn.hellojarvis.entity.Goods;
import cn.hellojarvis.entity.UserAddress;
import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.service.impl.HaveGoodsServiceImpl;
import cn.hellojarvis.service.impl.RequestPageServiceImpl;
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

    @RequestMapping("/loadUserGoods")
    public ModelAndView loadUserGoods(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        List<Goods> goodsList = haveGoodsService.loadUserGoods(userInfo.getUserId());
        if (goodsList!=null){
            request.getSession().setAttribute("goodsList",goodsList);
            modelAndView.setViewName("requestOrder(cUser)");
        }
        return modelAndView;
    }

    @RequestMapping("/loadUserAddress")
    public ModelAndView loadUserAddress(HttpServletRequest request) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        List<UserAddress> userAddrList = requestPageService.loadUserAddress(userInfo.getUserId());
        if (userAddrList!=null){
            request.getSession().setAttribute("userAddrList",userAddrList);
            modelAndView.setViewName("requestOrder(cUser)");
        }
        return modelAndView;
    }

}
