package cn.hellojarvis.controller;

import cn.hellojarvis.entity.UserLogin;
import cn.hellojarvis.service.impl.UserLoginServiceImpl;
import cn.personal.Captcha;
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
 * @create 2020/08/09 00:18
 */
@Controller("UserLoginController")
public class UserLoginController {
    @Autowired
    private UserLoginServiceImpl userLoginServiceImpl;

    @RequestMapping("/loginHandler")
    public ModelAndView loginHandler(UserLogin userLogin, HttpServletRequest request) throws IOException {
        String rst;
        if (userLoginServiceImpl.loadUser(userLogin)){
            rst="redirect:getUserInfo";
            request.getSession().setAttribute("User",userLogin);
        }else {
            request.setAttribute("loginError","用户名或密码错误");
            rst = "login";
        }
        return new ModelAndView(rst);
    }
    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Captcha captcha = new Captcha();
        request.getSession().setAttribute("captchaValue",captcha.getName());
        captcha.outputCaptcha(response.getOutputStream());
    }
    @RequestMapping("/checkCaptcha")
    public void checkCaptcha(HttpServletRequest request,HttpServletResponse response,String captcha) throws IOException {
        String captchaValue = (String) request.getSession().getAttribute("captchaValue");
        response.getWriter().print(captcha.equalsIgnoreCase(captchaValue)?"1":"0");
        response.getWriter().flush();
    }

    @RequestMapping("loginView")
    public ModelAndView loginView() {
        return new ModelAndView("login");
    }

}
