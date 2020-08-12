package cn.hellojarvis.controller;

import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.entity.UserLogin;
import cn.hellojarvis.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/09 13:54
 * 进行所有用户的个人信息修改，查看。
 */
@Controller("UserInfoController")
public class UserInfoController {
    @Autowired
    private UserInfoServiceImpl userInfoServiceImpl;


    @RequestMapping("/getUserInfo")
    public ModelAndView getUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserLogin user = (UserLogin) request.getSession().getAttribute("User");
        UserInfo userInfo = userInfoServiceImpl.loadUserInfoById(user.getUserId());
        request.getSession().setAttribute("UserInfo",userInfo);
        return new ModelAndView("index");
    }

    @RequestMapping("/modifyUserInfo")
    public void modifyUserInfo(UserInfo userInfo,HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println(userInfo);
        boolean b = userInfoServiceImpl.modifyUserInfo(userInfo);
        response.setContentType("text/html;charset=utf-8");
        if (b){
            request.getSession().setAttribute("UserInfo",userInfoServiceImpl.loadUserInfoById(userInfo.getUserId()));
            response.getWriter().print("修改成功");
        }else {
            response.getWriter().print("修改失败,请重试");
        }
        response.getWriter().flush();
    }

    /**
     *
     * @param request 请求
     * @return 调用getUserInfo
     */
    @RequestMapping("/indexView")
    public ModelAndView indexView(HttpServletRequest request){
        //连接login后删除下面四行
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(1001);
        userLogin.setUserPwd("123");
        request.getSession().setAttribute("User",userLogin);
        return new ModelAndView("redirect:getUserInfo");
    }
    /**
     *     切换到修改界面
     */
    @RequestMapping("/modifyView")
    public ModelAndView modifyView(){
        return new ModelAndView("modifyUserInfo");
    }

}
