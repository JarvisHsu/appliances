/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-08-12 00:30:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("    <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Image/favicon.ico\">\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\"\r\n");
      out.write("          content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui\">\r\n");
      out.write("    <title>Home</title>\r\n");
      out.write("    <!-- FontAwesome -->\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/font-awesome-4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Twitter Bootstrap -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/bootstrap-4.5.0-dist/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/CSS/IndexTable/default.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/CSS/IndexTable/bootstrap-vertical-menu.css\">\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jQuery/jquery-3.5.1.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-vertical-left\">\r\n");
      out.write("    <ul class=\"nav navbar-nav\">\r\n");
      out.write("        <li id=\"welcome\">\r\n");
      out.write("            <a style=\"cursor: pointer;\">\r\n");
      out.write("                <i class=\"fa fa-fw fa-lg fa-home\"></i>\r\n");
      out.write("                <span id=\"wel\">欢迎页</span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li id=\"label1\">\r\n");
      out.write("            <a style=\"cursor: pointer;\">\r\n");
      out.write("                <i class=\"fa fa-fw fa-lg fa-download \"></i>\r\n");
      out.write("                <span id=\"fun1\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li id=\"label2\">\r\n");
      out.write("            <a style=\"cursor: pointer;\">\r\n");
      out.write("                <i class=\"fa fa-fw fa-lg fa-comments-o\"></i>\r\n");
      out.write("                <span id=\"fun2\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li id=\"label3\">\r\n");
      out.write("            <a style=\"cursor: pointer;\">\r\n");
      out.write("                <i class=\"fa fa-fw fa-lg fa-desktop\"></i>\r\n");
      out.write("                <span id=\"fun3\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li id=\"label4\">\r\n");
      out.write("            <a style=\"cursor: pointer;\">\r\n");
      out.write("                <i class=\"fa fa-fw fa-lg fa-tablet\"></i>\r\n");
      out.write("                <span id=\"fun4\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li id=\"label5\">\r\n");
      out.write("            <a style=\"cursor: pointer;\">\r\n");
      out.write("                <i class=\"fa fa-fw fa-lg fa-laptop\"></i>\r\n");
      out.write("                <span id=\"fun5\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"htmleaf-container\">\r\n");
      out.write("    <header class=\"htmleaf-header\">\r\n");
      out.write("        <h1>您好,");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("<span>Welcome to JarvisHsu's personal space</span></h1>\r\n");
      out.write("        <div class=\"htmleaf-links\">\r\n");
      out.write("            <a class=\"htmleaf-icon icon-htmleaf-home-outline\" href=\"#\" title=\"Home\"\r\n");
      out.write("               target=\"\"><span> Home</span></a>\r\n");
      out.write("            <a class=\"htmleaf-icon icon-htmleaf-arrow-forward-outline\"\r\n");
      out.write("               href=\"#\" title=\"LogOut\" target=\"\"><span> LogOut</span></a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("    <div class=\"htmleaf-content bgcolor-8\">\r\n");
      out.write("        <h2>项目摘要</h2>\r\n");
      out.write("        <p>1.客户模块\r\n");
      out.write("            （1）请求维修。客户可以通过售后服务系统进行请求维修；\r\n");
      out.write("            （2）维护个人信息。客户可以查看和修改个人信息；\r\n");
      out.write("            （3）付费。客户可以通过售后服务平台对维修服务进行付费；\r\n");
      out.write("            （4）评论。客户可以对自己的评论进行查看和修改。\r\n");
      out.write("            2.公司客服模块\r\n");
      out.write("            （1）查看维修服务请求。公司客服可以通过售后服务系统查看客户提交的维修服务请求；\r\n");
      out.write("            （2）派单。公司客服派相应的维修人员去进行维修；\r\n");
      out.write("            （3）维护个人信息。公司客服可以查看和修改个人信息。\r\n");
      out.write("            （4）查看评论。公司客服可以查看客户对售后服务的评价。\r\n");
      out.write("            3.维修人员模块\r\n");
      out.write("            （1）查看派单：维修人员可以通过售后服务系统查看公司客服派给自己的维修服务单；\r\n");
      out.write("            （2）维护个人信息。维修人员可以查看和修改个人信息。\r\n");
      out.write("            4.系统管理员模块\r\n");
      out.write("            （1）管理公司客服信息。系统管理员可以给公司客服分配账号并管理其信息；\r\n");
      out.write("            （2）管理维修人员信息。系统管理员可以给维修人员分配账号并管理其信息；\r\n");
      out.write("            （3）维护个人信息。系统管理员查看和修改个人信息。\r\n");
      out.write("            （4）查看各公司售后服务情况。\r\n");
      out.write("        </p>\r\n");
      out.write("        <p>本项目产品正处于测试阶段，您所使用的产品并非最终版本。最终解释权归系统管理员所有</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"related\" hidden>\r\n");
      out.write("\r\n");
      out.write("        <h3>如果你喜欢这个插件，那么你可能也喜欢:</h3>\r\n");
      out.write("        <a href=\"#\">\r\n");
      out.write("            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Image/online_campaign_monochromatic.svg\" width=\"280px\"\r\n");
      out.write("                 alt=\"时尚响应式侧边栏布局和切换页面动画特效\"/>\r\n");
      out.write("            <h3>时尚响应式侧边栏布局和切换页面动画特效</h3>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"#\">\r\n");
      out.write("            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Image/online_campaign_monochromatic.svg\" width=\"280px\"\r\n");
      out.write("                 alt=\"谷歌Material design风格隐藏侧边栏特效\"/>\r\n");
      out.write("            <h3>谷歌Material design风格隐藏侧边栏特效</h3>\r\n");
      out.write("        </a>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div class=\"related\">\r\n");
      out.write("        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Image/1920_358.png\" alt=\"\">\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<p style=\"color: rgba(1,1,1,0.2);position: absolute; bottom: 0;right: 40%;\">Created by IntelliJ IDEA.author :\r\n");
      out.write("    JarvisHsu.Version:0.1</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    //标记标签功能\r\n");
      out.write("    $(function () {\r\n");
      out.write("        var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.role.roleName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("        if (str === '客户') {\r\n");
      out.write("            $(\"#fun1\").text(\"请求维修\").click(function (){\r\n");
      out.write("                post(\"loadUserGoods\")\r\n");
      out.write("            });\r\n");
      out.write("            $(\"#fun2\").text(\"个人信息\");\r\n");
      out.write("            $(\"#fun3\").text(\"付费\");\r\n");
      out.write("            $(\"#fun4\").text(\"评论\");\r\n");
      out.write("            $(\"#fun5\").text(\"暂未开通\");\r\n");
      out.write("        }\r\n");
      out.write("        if (str === '客服') {\r\n");
      out.write("            $(\"#fun1\").text(\"服务请求\");\r\n");
      out.write("            $(\"#fun2\").text(\"个人信息\");\r\n");
      out.write("            $(\"#fun3\").text(\"派单\");\r\n");
      out.write("            $(\"#fun4\").text(\"查看评论\");\r\n");
      out.write("            $(\"#fun5\").text(\"暂未开通\");\r\n");
      out.write("        }\r\n");
      out.write("        if (str === '维修人员') {\r\n");
      out.write("            $(\"#fun1\").text(\"查看派单\");\r\n");
      out.write("            $(\"#fun2\").text(\"个人信息\");\r\n");
      out.write("            $(\"#fun3\").text(\"暂未开通\");\r\n");
      out.write("            $(\"#fun4\").text(\"暂未开通\");\r\n");
      out.write("            $(\"#fun5\").text(\"暂未开通\");\r\n");
      out.write("        }\r\n");
      out.write("        if (str === '系统管理员') {\r\n");
      out.write("            $(\"#fun1\").text(\"维修人员\");\r\n");
      out.write("            $(\"#fun2\").text(\"个人信息\");\r\n");
      out.write("            $(\"#fun3\").text(\"公司客服\");\r\n");
      out.write("            $(\"#fun4\").text(\"售后服务\");\r\n");
      out.write("            $(\"#fun5\").text(\"暂未开通\");\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("    $(\"#fun2\").click(function () {\r\n");
      out.write("        post(\"modifyView\");\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //post请求通用跳转页面\r\n");
      out.write("    function post(url, params) {\r\n");
      out.write("        // 创建form元素\r\n");
      out.write("        var temp_form = document.createElement(\"form\");\r\n");
      out.write("        // 设置form属性\r\n");
      out.write("        temp_form.action = url;\r\n");
      out.write("        temp_form.target = \"_self\";\r\n");
      out.write("        temp_form.method = \"post\";\r\n");
      out.write("        temp_form.style.display = \"none\";\r\n");
      out.write("        // 处理需要传递的参数\r\n");
      out.write("        for (var x in params) {\r\n");
      out.write("            var opt = document.createElement(\"textarea\");\r\n");
      out.write("            opt.name = x;\r\n");
      out.write("            opt.value = params[x];\r\n");
      out.write("            temp_form.appendChild(opt);\r\n");
      out.write("        }\r\n");
      out.write("        document.body.appendChild(temp_form);\r\n");
      out.write("        // 提交表单\r\n");
      out.write("        temp_form.submit();\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
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
