/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-08-11 14:27:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class modifyUserInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>modifyUserInfo</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("    * {\r\n");
      out.write("        padding: 0;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    a {\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    body {\r\n");
      out.write("        height: 100vh;\r\n");
      out.write("        background: linear-gradient(#04B4AE, #D8D8D8, #58ACFA);\r\n");
      out.write("        display: flex;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        font-size: 16px;\r\n");
      out.write("        color: #190707;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    table {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: auto;\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .Info {\r\n");
      out.write("        width: 200px;\r\n");
      out.write("        height: 50px;\r\n");
      out.write("        font-size: 30px;\r\n");
      out.write("        background: transparent;\r\n");
      out.write("        border: none;\r\n");
      out.write("        outline: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    tr {\r\n");
      out.write("        line-height: 15px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    td {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        font-size: 25px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    h2 {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        color: #ffffff;\r\n");
      out.write("        margin-bottom: 30px;\r\n");
      out.write("        cursor: default;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .board {\r\n");
      out.write("        width: 400px;\r\n");
      out.write("        height: auto;\r\n");
      out.write("        background: rgba(0, 0, 0, 0.1);\r\n");
      out.write("        box-shadow: 0 15px 25px 0 rgba(0, 0, 0, 0.6);\r\n");
      out.write("        padding: 40px;\r\n");
      out.write("        z-index: 1;\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .bubble-legend-symbol {\r\n");
      out.write("        margin: 15px auto 0;\r\n");
      out.write("        width: 100px;\r\n");
      out.write("        height: 40px;\r\n");
      out.write("        border-radius: 30px;\r\n");
      out.write("        font-size: 20px;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        outline: none;\r\n");
      out.write("        border-bottom: 1px solid black;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jQuery/jquery-3.5.1.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"board\">\r\n");
      out.write("    <h2>查看或修改您的信息</h2>\r\n");
      out.write("    <form>\r\n");
      out.write("        <table cellspacing=\"0\">\r\n");
      out.write("            <tr hidden>\r\n");
      out.write("                <td>\r\n");
      out.write("                    用户ID\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"Info\" id=\"userId\" type=\"text\" name=\"userId\" hidden\r\n");
      out.write("                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr hidden>\r\n");
      out.write("                <td>\r\n");
      out.write("                    角色ID\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"Info\" id=\"roleId\" type=\"text\" name=\"roleId\" hidden\r\n");
      out.write("                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.roleId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.roleId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                    昵称\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"Info\" id=\"userName\" type=\"text\" name=\"userName\"\r\n");
      out.write("                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("                           autocomplete=\"off\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                    手机\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"Info\" id=\"userPhone\" type=\"text\" name=\"userPhone\"\r\n");
      out.write("                           placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.userPhone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.userPhone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("                           autocomplete=\"off\" oninvalid=\"setCustomValidity('手机号码格式不正确')\"\r\n");
      out.write("                           pattern=\"(\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                    性别\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input type=\"radio\" class=\"userGender\" id=\"man\" name=\"UserSex\" value=\"男\">男&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                    <input type=\"radio\" class=\"userGender\" id=\"woman\" name=\"UserSex\" value=\"女\">女\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                    生日\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"Info\" style=\"font-size: 20px\" id=\"userBirthday\" name=\"userBirthday\" type=\"date\"\r\n");
      out.write("                           min=\"1970-01-01\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.userBirthday}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("                           autocomplete=\"off\" required=\"required\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr hidden>\r\n");
      out.write("                <td>\r\n");
      out.write("                    创建日期\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"Info\" id=\"createDate\" name=\"createDate\" type=\"text\" hidden\r\n");
      out.write("                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.createDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("                           placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.createDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr hidden>\r\n");
      out.write("                <td>\r\n");
      out.write("                    更新日期\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"Info\" id=\"updateDate\" type=\"text\" name=\"updateDate\"\r\n");
      out.write("                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.updateDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" hidden\r\n");
      out.write("                           placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.updateDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr hidden>\r\n");
      out.write("                <td>\r\n");
      out.write("                    角色Id\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"Info\" id=\"role.roleId\" type=\"text\" name=\"role.roleId\"\r\n");
      out.write("                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.role.roleId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" hidden\r\n");
      out.write("                           placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.role.roleId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr hidden>\r\n");
      out.write("                <td>\r\n");
      out.write("                    角色名称\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"Info\" id=\"role.roleName\" type=\"text\" name=\"role.roleName\"\r\n");
      out.write("                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.role.roleName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" hidden\r\n");
      out.write("                           placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.role.roleName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <div style=\"width: 210px;margin: 0 auto\"><input class=\"bubble-legend-symbol\" id=\"putOn\" type=\"button\"\r\n");
      out.write("                                                        value=\"提交\">\r\n");
      out.write("            <input class=\"bubble-legend-symbol\" id=\"back\" type=\"button\" value=\"返回\"></div>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    var radios = document.getElementsByName(\"UserSex\");\r\n");
      out.write("    if (\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.UserInfo.userGender}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" === \"男\") {\r\n");
      out.write("        $(\"#man\").checked = true;\r\n");
      out.write("        radios[0].checked = true;\r\n");
      out.write("    } else {\r\n");
      out.write("        $(\"#woman\").checked = true;\r\n");
      out.write("        radios[1].checked = true;\r\n");
      out.write("    }\r\n");
      out.write("    console.log(radios[0].checked)\r\n");
      out.write("    console.log(radios[1].checked)\r\n");
      out.write("\r\n");
      out.write("    $(\"#putOn\").click(function () {\r\n");
      out.write("        var userId = $(\"#userId\").val();\r\n");
      out.write("        var roleId = $(\"#roleId\").val();\r\n");
      out.write("        var userName = $(\"#userName\").val();\r\n");
      out.write("        var userPhone = $(\"#userPhone\").val();\r\n");
      out.write("        var userBirthday = $(\"#userBirthday\").val();\r\n");
      out.write("        var createDate = $(\"#createDate\").val();\r\n");
      out.write("        var updateDate = $(\"#updateDate\").val();\r\n");
      out.write("        var roleroleId = $(\"#role.roleId\").val();\r\n");
      out.write("        var roleroleName = $(\"#role.roleName\").val();\r\n");
      out.write("        if (radios[0].checked ===true) {\r\n");
      out.write("            var userGender = $(\"#man\").val();\r\n");
      out.write("        }\r\n");
      out.write("        if (radios[1].checked === true){\r\n");
      out.write("            var userGender = $(\"#woman\").val();\r\n");
      out.write("        }\r\n");
      out.write("        console.log(userGender)\r\n");
      out.write("        $.post(\"modifyUserInfo\", {\r\n");
      out.write("            \"userId\": userId,\r\n");
      out.write("            \"roleId\": roleId,\r\n");
      out.write("            \"userName\": userName,\r\n");
      out.write("            \"userPhone\": userPhone,\r\n");
      out.write("            \"userGender\": userGender,\r\n");
      out.write("            \"userBirthday\": userBirthday,\r\n");
      out.write("            \"createDate\": createDate,\r\n");
      out.write("            \"updateDate\": updateDate,\r\n");
      out.write("            \"role.roleId\": roleroleId,\r\n");
      out.write("            \"role.roleName\": roleroleName\r\n");
      out.write("        }, function (data) {\r\n");
      out.write("            alert(data);\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    $(\"#back\").click(function () {\r\n");
      out.write("        post(\"/getUserInfo\");\r\n");
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