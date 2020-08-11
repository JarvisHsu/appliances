<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>modifyUserInfo</title>
</head>
<style>
    * {
        padding: 0;
        margin: 0;
    }

    a {
        text-decoration: none;
    }

    body {
        height: 100vh;
        background: linear-gradient(#04B4AE, #D8D8D8, #58ACFA);
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 16px;
        color: #190707;
    }

    table {
        width: 100%;
        height: auto;

    }

    .Info {
        width: 200px;
        height: 50px;
        font-size: 30px;
        background: transparent;
        border: none;
        outline: none;
    }

    tr {
        line-height: 15px;
    }

    td {
        text-align: center;
        font-size: 25px;
    }

    h2 {
        text-align: center;
        color: #ffffff;
        margin-bottom: 30px;
        cursor: default;
    }

    .board {
        width: 400px;
        height: auto;
        background: rgba(0, 0, 0, 0.1);
        box-shadow: 0 15px 25px 0 rgba(0, 0, 0, 0.6);
        padding: 40px;
        z-index: 1;
        box-sizing: border-box;
    }

    .bubble-legend-symbol {
        margin: 15px auto 0;
        width: 100px;
        height: 40px;
        border-radius: 30px;
        font-size: 20px;
        cursor: pointer;
        outline: none;
        border-bottom: 1px solid black;
    }
</style>
<script src="${pageContext.request.contextPath}/jQuery/jquery-3.5.1.js" type="text/javascript"></script>
<body>
<div class="board">
    <h2>请修改您的信息</h2>
    <form action="modifyUserInfo" method="post">
        <table cellspacing="0">
            <tr hidden>
                <td>
                    用户ID
                </td>
                <td>
                    <input class="Info" type="text" name="userId" hidden value="${sessionScope.UserInfo.userId}" placeholder="${sessionScope.UserInfo.userId}">
                </td>
            </tr>
            <tr hidden>
                <td>
                    角色ID
                </td>
                <td>
                    <input class="Info" type="text" name="roleId" hidden value="${sessionScope.UserInfo.roleId}" placeholder="${sessionScope.UserInfo.roleId}">
                </td>
            </tr>
            <tr>
                <td>
                    昵称
                </td>
                <td>
                    <input class="Info" id="name" type="text" name="userName" value="${sessionScope.UserInfo.userName}" placeholder="${sessionScope.UserInfo.userName}"
                           autocomplete="off">
                </td>
            </tr>
            <tr>
                <td>
                    手机
                </td>
                <td>
                    <input class="Info" id="phone" type="text" name="userPhone" placeholder="${sessionScope.UserInfo.userPhone}" value="${sessionScope.UserInfo.userPhone}"
                           autocomplete="off" oninvalid="setCustomValidity('手机号码格式不正确')"
                           pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$">
                </td>
            </tr>
            <tr>
                <td>
                    性别
                </td>
                <td>
                    <input type="radio" id="man" name="userGender" value="男">男&nbsp;&nbsp;&nbsp;
                    <input type="radio" id="woman" name="userGender" value="女">女
                </td>
            </tr>
            <tr>
                <td>
                    生日
                </td>
                <td>
                    <input class="Info" style="font-size: 20px" id="userBirthday" name="userBirthday" type="date" min="1970-01-01"  value="${sessionScope.UserInfo.userBirthday}"
                           autocomplete="off" required="required">
                </td>
            </tr>
            <tr hidden>
                <td>
                    创建日期
                </td>
                <td>
                    <input class="Info" name="createDate" type="text" hidden value="${sessionScope.UserInfo.createDate}" placeholder="${sessionScope.UserInfo.createDate}">
                </td>
            </tr>
            <tr hidden>
                <td>
                    更新日期
                </td>
                <td>
                    <input class="Info" type="text" name="updateDate" value="${sessionScope.UserInfo.updateDate}" hidden placeholder="${sessionScope.UserInfo.updateDate}">
                </td>
            </tr>
            <tr hidden>
                <td>
                    角色Id
                </td>
                <td>
                    <input class="Info" type="text" name="role.roleId" value="${sessionScope.UserInfo.role.roleId}" hidden placeholder="${sessionScope.UserInfo.role.roleId}">
                </td>
            </tr>
            <tr hidden>
                <td>
                    角色名称
                </td>
                <td>
                    <input class="Info" type="text" name="role.roleName" value="${sessionScope.UserInfo.role.roleName}" hidden placeholder="${sessionScope.UserInfo.role.roleName}">
                </td>
            </tr>
        </table>
        <div style="width: 210px;margin: 0 auto"><input class="bubble-legend-symbol" id="putOn" type="submit" value="提交">
            <input class="bubble-legend-symbol" id="back" type="button" value="返回"></div>
    </form>
</div>
</body>
<script>
    if("${sessionScope.UserInfo.userGender}"==='男'){
        $("#man").attr("checked","checked");
    }else{
        $("#woman").attr("checked","checked");
    }


    $("#back").click(function () {
        post("/indexView");
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
<%@include file="/WEB-INF/public/booter.jsp"%>