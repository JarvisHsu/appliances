/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-08-09 05:51:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/public/booter.jsp", Long.valueOf(1596942807500L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Login</title>\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Image/favicon.ico\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/CSS/LoginTable/LoginStyle.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("<div id=\"top-image\">\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"LoginBox\">\r\n");
      out.write("    <h2>家电售后服务平台</h2>\r\n");
      out.write("    <form action=\"loginHandler\" method=\"post\">\r\n");
      out.write("        <div class=\"item\">\r\n");
      out.write("            <input id=\"user_id\" type=\"text\" required name=\"UserId\" value=\"1001\" autocomplete=\"off\">\r\n");
      out.write("            <label>UserId</label>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"item\" id=\"password-label\">\r\n");
      out.write("            <input id=\"password\" type=\"password\" required name=\"userPwd\" value=\"123\" autocomplete=\"off\">\r\n");
      out.write("            <label>PassWord</label>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"item\" id=\"div_captcha\">\r\n");
      out.write("            <input id=\"cap_input\" type=\"text\" required name=\"Captcha\" value=\"\" autocomplete=\"off\">\r\n");
      out.write("            <label>Captcha</label>\r\n");
      out.write("            <a href=\"#\" id=\"touch\"><img id=\"captcha_img\" src=\"getCaptcha\" alt=\"\"></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <button class=\"btn\" value=\"\">submit\r\n");
      out.write("            <span></span>\r\n");
      out.write("            <span></span>\r\n");
      out.write("            <span></span>\r\n");
      out.write("            <span></span>\r\n");
      out.write("        </button>\r\n");
      out.write("        <p id=\"loginError\" style='display: inline;margin-left: 25px;color: red;'>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.loginError}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("    </form>\r\n");
      out.write("    <p id=\"register\"><a href=\"#\" onclick=\"error()\">Create a new account for free</a></p>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>window.jQuery || document.write('<script src=\"/jQuery/jquery-1.11.0.min.js\"><\\/script>')</script>\r\n");
      out.write("<script>\r\n");
      out.write("    $(\"#cap_input\").blur(function () {\r\n");
      out.write("       var captcha = this.value;\r\n");
      out.write("       $.post(\"checkCaptcha\",{\"captcha\":captcha},function (data) {\r\n");
      out.write("           var log_message = $(\"<p id='log_message' style='display: inline;margin-left: 25px;'>\");\r\n");
      out.write("           if (data === '0') {\r\n");
      out.write("               log_message.css(\"color\", \"red\").text(\"验证码错误\");\r\n");
      out.write("           } else {\r\n");
      out.write("               log_message.css(\"color\", \"green\").text(\"验证码正确\");\r\n");
      out.write("           }\r\n");
      out.write("           if ($(\"#loginError\").text() !== '') {\r\n");
      out.write("               $(\"#loginError\").remove();\r\n");
      out.write("           }\r\n");
      out.write("           if ($(\"#log_message\").text() !== '') {\r\n");
      out.write("               $(\"#log_message\").remove();\r\n");
      out.write("           }\r\n");
      out.write("           $(\".btn\").after(log_message);\r\n");
      out.write("           if ($(\"#log_message\").text() === '验证码错误' || $(\"#log_message\").text() === '用户名或密码错误') {\r\n");
      out.write("               $(\"#captcha_img\").attr(\"src\", \"/getCaptcha?\" + new Date().getTime());\r\n");
      out.write("           }\r\n");
      out.write("       });\r\n");
      out.write("    });\r\n");
      out.write("    function error() {\r\n");
      out.write("        alert(\"暂未开通注册业务！\")\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    $(\"#touch\").click(function () {\r\n");
      out.write("         $(\"#captcha_img\").attr(\"src\", \"/getCaptcha?\" + new Date().getTime());\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("        $(\"#top-image\").iosParallax({\r\n");
      out.write("            movementFactor: 50\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("    window.addEventListener(\"keydown\", function (event) {\r\n");
      out.write("        if (event.defaultPrevented) {\r\n");
      out.write("            return; // Should do nothing if the default action has been cancelled\r\n");
      out.write("        }\r\n");
      out.write("        var handled = false;\r\n");
      out.write("        var code;\r\n");
      out.write("        //Get The Value Entered By The Keyboard\r\n");
      out.write("        if (event.key !== undefined) {\r\n");
      out.write("            // Handle the event with KeyboardEvent.key and set handled true.\r\n");
      out.write("            code = event.key;\r\n");
      out.write("        } else if (event.keyIdentifier !== undefined) {\r\n");
      out.write("            // Handle the event with KeyboardEvent.key and set handled true.\r\n");
      out.write("            code = event.keyIdentifier;\r\n");
      out.write("        } else if (event.keyCode !== undefined) {\r\n");
      out.write("            // Handle the event with KeyboardEvent.key and set handled true.\r\n");
      out.write("            code = event.keyCode;\r\n");
      out.write("        }\r\n");
      out.write("        if (code === \"Enter\") {\r\n");
      out.write("            checkLogin();\r\n");
      out.write("            handled = true;\r\n");
      out.write("        }\r\n");
      out.write("        if (handled) {\r\n");
      out.write("            // Suppress \"double action\" if event handled\r\n");
      out.write("            event.preventDefault();\r\n");
      out.write("        }\r\n");
      out.write("    }, true);\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<!-- 全局js -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jQuery/jquery-3.5.1.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jQuery/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- 自定义js -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/JS/ios-parallax.js\"></script>\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("  ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}