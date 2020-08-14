package cn.hellojarvis.controller;

import cn.hellojarvis.entity.RequestPage;
import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller("S_UserOperationController")
public class S_UserOperationController {
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

    @RequestMapping("/loadUsersOrdersWithRequesting")
    public ModelAndView loadUsersOrdersWithRequesting(HttpServletRequest request) {
        List<RequestPage> requestPages = requestPageService.loadAllUsersOrdersWithRequesting();
        request.setAttribute("allUsersOrders", requestPages);
        return new ModelAndView("viewOrder");
    }

    @RequestMapping("/loadFixer")
    public @ResponseBody
    List<UserInfo> loadFixer() {
        return userInfoService.loadUserByRoleId(3);
    }

    @RequestMapping("/loadFixerOrders")
    public @ResponseBody
    List<Integer> loadFixerOrders(@RequestParam(value = "fixId") String FixId) {
        String[] fixId = FixId.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < fixId.length; i++) {
            list.add(requestPageService.loadFixerOrders((int) Double.parseDouble(fixId[i])));
        }
        return list;
    }
    //更新客服Id，更新技工Id，更新当前状态
    @RequestMapping("updateFixSend")
    public ModelAndView updateFixSend(HttpServletRequest request){
        Integer fixId  = Integer.valueOf(request.getParameter("0"));
        Integer senderId = Integer.valueOf(request.getParameter("1"));
        Integer orderId = Integer.valueOf(request.getParameter("2"));
        RequestPage requestPage = new RequestPage();
        requestPage.setOrderId(orderId);
        requestPage.setFixId(fixId);
        requestPage.setSenderId(senderId);
        requestPage.setStatus("2");
        boolean bool = requestPageService.updateFixSend(requestPage);
        if (bool){
            request.setAttribute("payErrorMessage","分派成功！");
        }else {
            request.setAttribute("payErrorMessage","分派失败！请稍后重试");
        }
        List<RequestPage> requestPages = requestPageService.loadAllUsersOrdersWithRequesting();
        request.setAttribute("allUsersOrders", requestPages);
        return new ModelAndView("viewOrder");
    }
}
