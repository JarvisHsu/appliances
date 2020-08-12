<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Image/favicon.ico">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui">
    <title>Home</title>
    <!-- FontAwesome -->
    <link href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Twitter Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/IndexTable/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/IndexTable/bootstrap-vertical-menu.css">
    <script src="${pageContext.request.contextPath}/jQuery/jquery-3.5.1.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-vertical-left">
    <ul class="nav navbar-nav">
        <li id="welcome">
            <a style="cursor: pointer;">
                <i class="fa fa-fw fa-lg fa-home"></i>
                <span id="wel">欢迎页</span>
            </a>
        </li>
        <li id="label1">
            <a style="cursor: pointer;">
                <i class="fa fa-fw fa-lg fa-download "></i>
                <span id="fun1"></span>
            </a>
        </li>
        <li id="label2">
            <a style="cursor: pointer;">
                <i class="fa fa-fw fa-lg fa-comments-o"></i>
                <span id="fun2"></span>
            </a>
        </li>
        <li id="label3">
            <a style="cursor: pointer;">
                <i class="fa fa-fw fa-lg fa-desktop"></i>
                <span id="fun3"></span>
            </a>
        </li>
        <li id="label4">
            <a style="cursor: pointer;">
                <i class="fa fa-fw fa-lg fa-tablet"></i>
                <span id="fun4"></span>
            </a>
        </li>
        <li id="label5">
            <a style="cursor: pointer;">
                <i class="fa fa-fw fa-lg fa-laptop"></i>
                <span id="fun5"></span>
            </a>
        </li>
    </ul>
</nav>
<div class="htmleaf-container">
    <header class="htmleaf-header">
        <h1>您好,${sessionScope.UserInfo.userName}<span>Welcome to JarvisHsu's personal space</span></h1>
        <div class="htmleaf-links">
            <a class="htmleaf-icon icon-htmleaf-home-outline" href="#" title="Home"
               target=""><span> Home</span></a>
            <a class="htmleaf-icon icon-htmleaf-arrow-forward-outline"
               href="#" title="LogOut" target=""><span> LogOut</span></a>
        </div>
    </header>
    <div class="htmleaf-content bgcolor-8">
        <h2>项目摘要</h2>
        <p>1.客户模块
            （1）请求维修。客户可以通过售后服务系统进行请求维修；
            （2）维护个人信息。客户可以查看和修改个人信息；
            （3）付费。客户可以通过售后服务平台对维修服务进行付费；
            （4）评论。客户可以对自己的评论进行查看和修改。
            2.公司客服模块
            （1）查看维修服务请求。公司客服可以通过售后服务系统查看客户提交的维修服务请求；
            （2）派单。公司客服派相应的维修人员去进行维修；
            （3）维护个人信息。公司客服可以查看和修改个人信息。
            （4）查看评论。公司客服可以查看客户对售后服务的评价。
            3.维修人员模块
            （1）查看派单：维修人员可以通过售后服务系统查看公司客服派给自己的维修服务单；
            （2）维护个人信息。维修人员可以查看和修改个人信息。
            4.系统管理员模块
            （1）管理公司客服信息。系统管理员可以给公司客服分配账号并管理其信息；
            （2）管理维修人员信息。系统管理员可以给维修人员分配账号并管理其信息；
            （3）维护个人信息。系统管理员查看和修改个人信息。
            （4）查看各公司售后服务情况。
        </p>
        <p>本项目产品正处于测试阶段，您所使用的产品并非最终版本。最终解释权归系统管理员所有</p>
    </div>
    <div class="related" hidden>

        <h3>如果你喜欢这个插件，那么你可能也喜欢:</h3>
        <a href="#">
            <img src="${pageContext.request.contextPath}/Image/online_campaign_monochromatic.svg" width="280px"
                 alt="时尚响应式侧边栏布局和切换页面动画特效"/>
            <h3>时尚响应式侧边栏布局和切换页面动画特效</h3>
        </a>
        <a href="#">
            <img src="${pageContext.request.contextPath}/Image/online_campaign_monochromatic.svg" width="280px"
                 alt="谷歌Material design风格隐藏侧边栏特效"/>
            <h3>谷歌Material design风格隐藏侧边栏特效</h3>
        </a>
    </div>
    <%--    占位图--%>
    <div class="related">
        <img src="${pageContext.request.contextPath}/Image/1920_358.png" alt="">
    </div>
</div>
<p style="color: rgba(1,1,1,0.2);position: absolute; bottom: 0;right: 40%;">Created by IntelliJ IDEA.author :
    JarvisHsu.Version:0.1</p>


</body>
<script>
    //标记标签功能
    $(function () {
        var str = "${sessionScope.UserInfo.role.roleName}";
        if (str === '客户') {
            $("#fun1").text("请求维修").click(function (){
                post("loadUserGoods")
            });
            $("#fun2").text("个人信息");
            $("#fun3").text("付费");
            $("#fun4").text("评论");
            $("#fun5").text("暂未开通");
        }
        if (str === '客服') {
            $("#fun1").text("服务请求");
            $("#fun2").text("个人信息");
            $("#fun3").text("派单");
            $("#fun4").text("查看评论");
            $("#fun5").text("暂未开通");
        }
        if (str === '维修人员') {
            $("#fun1").text("查看派单");
            $("#fun2").text("个人信息");
            $("#fun3").text("暂未开通");
            $("#fun4").text("暂未开通");
            $("#fun5").text("暂未开通");
        }
        if (str === '系统管理员') {
            $("#fun1").text("维修人员");
            $("#fun2").text("个人信息");
            $("#fun3").text("公司客服");
            $("#fun4").text("售后服务");
            $("#fun5").text("暂未开通");
        }
    });
    $("#fun2").click(function () {
        post("modifyView");
    });

    //post请求通用跳转页面
    function post(url, params) {
        // 创建form元素
        var temp_form = document.createElement("form");
        // 设置form属性
        temp_form.action = url;
        temp_form.target = "_self";
        temp_form.method = "post";
        temp_form.style.display = "none";
        // 处理需要传递的参数
        for (var x in params) {
            var opt = document.createElement("textarea");
            opt.name = x;
            opt.value = params[x];
            temp_form.appendChild(opt);
        }
        document.body.appendChild(temp_form);
        // 提交表单
        temp_form.submit();
    }
</script>
</html>