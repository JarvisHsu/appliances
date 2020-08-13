<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>modifyUserInfo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/CommonStyle.css">
</head>
<style>
    .board {
        width: 400px;
        height: auto;
        background: rgba(0, 0, 0, 0.1);
        box-shadow: 0 15px 25px 0 rgba(0, 0, 0, 0.6);
        padding: 40px;
        z-index: 1;
        box-sizing: border-box;
    }
    .Info {
        width: 200px;
        height: 50px;
        font-size: 30px;
        background: transparent;
        border: none;
        outline: none;
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
        background: transparent;
    }
</style>
<script src="${pageContext.request.contextPath}/jQuery/jquery-3.5.1.js" type="text/javascript"></script>
<body>
<div class="board">
    <h2>查看或修改您的信息</h2>
    <form>
        <table cellspacing="0">
            <tr hidden>
                <td>
                    用户ID
                </td>
                <td>
                    <input class="Info" id="userId" type="text" name="userId" hidden
                           value="${sessionScope.UserInfo.userId}" placeholder="${sessionScope.UserInfo.userId}">
                </td>
            </tr>
            <tr hidden>
                <td>
                    角色ID
                </td>
                <td>
                    <input class="Info" id="roleId" type="text" name="roleId" hidden
                           value="${sessionScope.UserInfo.roleId}" placeholder="${sessionScope.UserInfo.roleId}">
                </td>
            </tr>
            <tr>
                <td>
                    昵称
                </td>
                <td>
                    <input class="Info" id="userName" type="text" name="userName"
                           value="${sessionScope.UserInfo.userName}" placeholder="${sessionScope.UserInfo.userName}"
                           autocomplete="off">
                </td>
            </tr>
            <tr>
                <td>
                    手机
                </td>
                <td>
                    <input class="Info" id="userPhone" type="text" name="userPhone"
                           placeholder="${sessionScope.UserInfo.userPhone}" value="${sessionScope.UserInfo.userPhone}"
                           autocomplete="off" oninvalid="setCustomValidity('手机号码格式不正确')"
                           pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$">
                </td>
            </tr>
            <tr>
                <td>
                    性别
                </td>
                <td>
                    <input type="radio" style="cursor: pointer;" class="userGender" id="man" name="UserSex" value="男">男&nbsp;&nbsp;&nbsp;
                    <input type="radio" style="cursor: pointer;" class="userGender" id="woman" name="UserSex" value="女">女
                </td>
            </tr>
            <tr>
                <td>
                    生日
                </td>
                <td>
                    <input class="Info" style="font-size: 20px;cursor: pointer;" id="userBirthday" name="userBirthday" type="date"
                           min="1970-01-01" value="${sessionScope.UserInfo.userBirthday}"
                           autocomplete="off" required="required">
                </td>
            </tr>
            <tr hidden>
                <td>
                    创建日期
                </td>
                <td>
                    <input class="Info" id="createDate" name="createDate" type="text" hidden
                           value="${sessionScope.UserInfo.createDate}"
                           placeholder="${sessionScope.UserInfo.createDate}">
                </td>
            </tr>
            <tr hidden>
                <td>
                    更新日期
                </td>
                <td>
                    <input class="Info" id="updateDate" type="text" name="updateDate"
                           value="${sessionScope.UserInfo.updateDate}" hidden
                           placeholder="${sessionScope.UserInfo.updateDate}">
                </td>
            </tr>
            <tr hidden>
                <td>
                    角色Id
                </td>
                <td>
                    <input class="Info" id="role.roleId" type="text" name="role.roleId"
                           value="${sessionScope.UserInfo.role.roleId}" hidden
                           placeholder="${sessionScope.UserInfo.role.roleId}">
                </td>
            </tr>
            <tr hidden>
                <td>
                    角色名称
                </td>
                <td>
                    <input class="Info" id="role.roleName" type="text" name="role.roleName"
                           value="${sessionScope.UserInfo.role.roleName}" hidden
                           placeholder="${sessionScope.UserInfo.role.roleName}">
                </td>
            </tr>
        </table>
        <div style="width: 210px;margin: 0 auto"><input class="bubble-legend-symbol" id="putOn" type="button"
                                                        value="提交">
            <input class="bubble-legend-symbol" id="back" type="button" value="返回"></div>
    </form>
</div>
</body>
<script>
    var radios = document.getElementsByName("UserSex");
    if ("${sessionScope.UserInfo.userGender}" === "男") {
        $("#man").checked = true;
        radios[0].checked = true;
    } else {
        $("#woman").checked = true;
        radios[1].checked = true;
    }
    console.log(radios[0].checked)
    console.log(radios[1].checked)

    $("#putOn").click(function () {
        var userId = $("#userId").val();
        var roleId = $("#roleId").val();
        var userName = $("#userName").val();
        var userPhone = $("#userPhone").val();
        var userBirthday = $("#userBirthday").val();
        var createDate = $("#createDate").val();
        var updateDate = $("#updateDate").val();
        var roleroleId = $("#role.roleId").val();
        var roleroleName = $("#role.roleName").val();
        if (radios[0].checked ===true) {
            var userGender = $("#man").val();
        }
        if (radios[1].checked === true){
            var userGender = $("#woman").val();
        }
        console.log(userGender)
        $.post("modifyUserInfo", {
            "userId": userId,
            "roleId": roleId,
            "userName": userName,
            "userPhone": userPhone,
            "userGender": userGender,
            "userBirthday": userBirthday,
            "createDate": createDate,
            "updateDate": updateDate,
            "role.roleId": roleroleId,
            "role.roleName": roleroleName
        }, function (data) {
            alert(data);
        });
    });


    $("#back").click(function () {
        post("/getUserInfo");
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
<%@include file="/WEB-INF/public/booter.jsp" %>