<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>欢迎您,${sessionScope.UserInfo.userName}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/CommonStyle.css">
</head>
<style>
    input {
        background: transparent;
        outline: none;
    }

    td {
        font-size: 20px;
    }

    .Orders {
        width: 1000px;
        background: rgba(0, 0, 0, 0.1);
        box-shadow: 0 15px 25px 0 rgba(0, 0, 0, 0.6);
        padding: 40px;
        z-index: 1;
        box-sizing: border-box;
    }
</style>
<body onload="errorMessage()">
<button  style="position: fixed;bottom: 0;right: 0;width: 100px;
height: 40px;background: transparent;border-radius: 50px;cursor: pointer;outline: none;"
         onclick="post('indexView')">首页
</button>
<c:if test="${sessionScope.UserInfo.roleId!=4}">
    <h2>您不是管理员，请<p onclick="post('getUserInfo')">返回</p></h2>
</c:if>
<c:if test="${sessionScope.UserInfo.roleId==4}">
    <%--技工列表--%>
    <c:if test="${requestScope.fixerList!=null}">
        <div class="Orders" style="width: 1100px;">
            <h2>维修人员列表</h2>
            <table border="1" cellspacing="0">
                <tr>
                    <th>员工编号</th>
                    <th>员工名称</th>
                    <th>员工性别</th>
                    <th>员工生日</th>
                    <th>员工手机</th>
                    <th>建号日期</th>
                    <th>最后更新</th>
                </tr>
                <c:forEach items="${requestScope.fixerList}" var="pageList">
                    <tr>
                        <td>${pageList.userId}</td>
                        <td>${pageList.userName}</td>
                        <td><c:if test="${pageList.userGender==null}">
                            -
                        </c:if>${pageList.userGender}</td>
                        <td><c:if test="${pageList.userBirthday==null}">
                            -
                        </c:if>${pageList.userBirthday}</td>
                        <td><c:if test="${pageList.userPhone==null}">
                            -
                        </c:if>${pageList.userPhone}</td>
                        <td>${pageList.createDate}</td>
                        <td>${pageList.updateDate}</td>
                    </tr>
                </c:forEach>
                <input type="button" id="addNewFixer" value="添加" style="cursor: pointer;">
            </table>
        </div>
    </c:if>
    <%--客服列表--%>
    <c:if test="${requestScope.serviceList!=null}">
        <div class="Orders" style="width: 1100px;">
            <h2>客服人员列表</h2>
            <table border="1" cellspacing="0">
                <tr>
                    <th>员工编号</th>
                    <th>员工名称</th>
                    <th>员工性别</th>
                    <th>员工生日</th>
                    <th>员工手机</th>
                    <th>建号日期</th>
                    <th>最后更新</th>
                </tr>
                <c:forEach items="${requestScope.serviceList}" var="pageList">
                    <tr>
                        <td>${pageList.userId}</td>
                        <td>${pageList.userName}</td>
                        <td><c:if test="${pageList.userGender==null}">
                            -
                        </c:if>${pageList.userGender}</td>
                        <td><c:if test="${pageList.userBirthday==null}">
                            -
                        </c:if>${pageList.userBirthday}</td>
                        <td><c:if test="${pageList.userPhone==null}">
                            -
                        </c:if>${pageList.userPhone}</td>
                        <td>${pageList.createDate}</td>
                        <td>${pageList.updateDate}</td>
                    </tr>
                </c:forEach>
                <input type="button" id="addNewService" value="添加" style="cursor: pointer;">
            </table>
        </div>
    </c:if>
</c:if>
</body>
<%@include file="../public/booter.jsp"%>
<script>
    function errorMessage(){
        if (${requestScope.errorMessage!=null}){
            alert('${requestScope.errorMessage}')
        }
    }
    $("#addNewFixer").click(function (){
       post("addNewFixer");
    });
    $("#addNewService").click(function (){
        post("addNewService");
    });
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
