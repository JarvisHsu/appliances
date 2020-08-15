package cn.hellojarvis.controller;

import cn.hellojarvis.entity.RequestPage;
import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.entity.UserLogin;
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
    @Autowired
    private IUserLoginService userLoginService;

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

    @RequestMapping("/addNewFixer")
    public ModelAndView addNewFixer(HttpServletRequest request){
        if (userLoginService.createUser()){
            UserLogin userLogin = userLoginService.loadNewestUser();
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userLogin.getUserId());
            userInfo.setRoleId(3);
            userInfo.setUserName("维修人员新号");
            userInfoService.createAnUser(userInfo);
            request.setAttribute("errorMessage","添加成功！");
        }else {
            request.setAttribute("errorMessage","创建失败，请重试");
        }
        List<UserInfo> fixerList = userInfoService.loadUserByRoleId(3);
        request.setAttribute("fixerList",fixerList);
        return new ModelAndView("rootManager");
    }
    @RequestMapping("/addNewService")
    public ModelAndView addNewService(HttpServletRequest request){
        if (userLoginService.createUser()){
            UserLogin userLogin = userLoginService.loadNewestUser();
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userLogin.getUserId());
            userInfo.setRoleId(2);
            userInfo.setUserName("客服人员新号");
            userInfoService.createAnUser(userInfo);
            request.setAttribute("errorMessage","添加成功！");
        }else {
            request.setAttribute("errorMessage","创建失败，请重试");
        }
        List<UserInfo> serviceList = userInfoService.loadUserByRoleId(2);
        request.setAttribute("serviceList",serviceList);
        return new ModelAndView("rootManager");
    }
}
