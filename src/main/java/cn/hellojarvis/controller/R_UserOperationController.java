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
 * @create 2020/08/15 15:22
 */
@Controller("R_UserOperationController")
public class R_UserOperationController {
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

    @RequestMapping("/loadAllFixer")
    public ModelAndView loadAllFixer(HttpServletRequest request){
        List<UserInfo> fixerList = userInfoService.loadUserByRoleId(3);
        request.setAttribute("fixerList",fixerList);
        return new ModelAndView("rootManager");
    }
    @RequestMapping("/loadAllService")
    public ModelAndView loadAllService(HttpServletRequest request){
        List<UserInfo> serviceList = userInfoService.loadUserByRoleId(2);
        request.setAttribute("serviceList",serviceList);
        return new ModelAndView("rootManager");
    }
    @RequestMapping("/loadAllOrders")
    public ModelAndView loadAllOrders(HttpServletRequest request){
        List<RequestPage> pageList = requestPageService.loadAllOrders();
        request.setAttribute("AllOrders",pageList);
        return new ModelAndView("viewOrder");
    }

}
