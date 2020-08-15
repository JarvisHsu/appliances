package cn.hellojarvis.controller;

import cn.hellojarvis.entity.RequestPage;
import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/15 14:13
 */
@Controller("F_UserOperationController")
public class F_UserOperationController {
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

    @RequestMapping("/loadFixerAllOrders")
    public ModelAndView loadFixerAllOrders(HttpServletRequest request){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        List<RequestPage> requestPages = requestPageService.loadFixerOrders(userInfo.getUserId());
        request.setAttribute("fixerAllOrders",requestPages);
        return new ModelAndView("viewOrder");
    }
    @RequestMapping("/updateFixerOrderStatus")
    public ModelAndView updateFixerOrderStatus(HttpServletRequest request){
        Integer orderId = Integer.valueOf(request.getParameter("0"));
        boolean b = requestPageService.updateOrderStatus("1", orderId);
        if (b){
            request.setAttribute("payErrorMessage","修理任务完成");
        }else {
            request.setAttribute("payErrorMessage","处理失败，请稍后重试或联系管理员进行处理");
        }
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        List<RequestPage> requestPages = requestPageService.loadFixerOrders(userInfo.getUserId());
        request.setAttribute("fixerAllOrders",requestPages);
        return new ModelAndView("viewOrder");
    }
}
