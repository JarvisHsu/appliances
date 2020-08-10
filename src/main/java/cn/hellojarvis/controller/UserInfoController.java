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
        boolean b = userInfoServiceImpl.modifyUserInfo(userInfo);
        if (b){
            request.getSession().setAttribute("UserInfo",userInfoServiceImpl.loadUserInfoById(userInfo.getUserId()));
            response.getWriter().print("1");
        }else {
            response.getWriter().print("0");
        }
        response.getWriter().flush();
    }

    @RequestMapping("/indexView")
    public ModelAndView indexView(HttpServletRequest request){
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(1001);
        userLogin.setUserPwd("123");
        request.getSession().setAttribute("User",userLogin);
        return new ModelAndView("redirect:getUserInfo");
    }
    @RequestMapping("/modifyView")
    public ModelAndView modifyView(){
        return new ModelAndView("modifyUserInfo");
    }

}