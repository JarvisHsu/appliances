<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--用户请求一个订单--%>
    <title>请求订单</title>
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
    .goods{
        width: 650px;
        position: absolute;
        left: 50px;
        top: 50px;
    }
    .address{
        width: 650px;
        position: absolute;
        top: 50px;
        right:50px;
    }

    table {
        width: 100%;
        height: auto;
    }
    th,td,tr{
        text-align: center;
    }
    tr{
        line-height: 30px;
    }
    h2 {
        text-align: center;
        color: #ffffff;
        margin-bottom: 30px;
        cursor: default;
    }
</style>
<body>
<C:if test="${sessionScope.goodsList!=null}">
<div class="goods">
    <h2>请选择需要维修的产品</h2>
    <table border="1" cellspacing="0">

            <tr>
                <th>产品Id</th>
                <th>产品名称</th>
                <th>产品信息</th>
            </tr>
            <C:forEach items="${sessionScope.goodsList}" var="goodsList">
                <tr>
                    <td>${goodsList.goodsId}</td>
                    <td>${goodsList.goodsName}</td>
                    <td>${goodsList.goodsInfo}</td>
                    <td><input style="background: rgba(255,255,255,0.2);border-radius: 10px;outline: none;cursor: pointer;" type="button" value="请求订单" onclick="requestOrder()"></td>
                </tr>
            </C:forEach>
    </table>
</div>
</C:if>
<C:if test="${sessionScope.userAddrList!=null}">
    <div class="address">
        <h2>请选择上门服务地址</h2>
        <table border="1" cellspacing="0">
            <tr>
                <th>省</th>
                <th>市</th>
                <th>区</th>
                <th>详细地址</th>
                <th>联系电话</th>
            </tr>
            <C:forEach items="${sessionScope.userAddrList}" var="addrList">
                <tr>
                    <td hidden>${addrList.addrId}</td>
                    <td>${addrList.province}</td>
                    <td>${addrList.city}</td>
                    <td>${addrList.area}</td>
                    <td>${addrList.address}</td>
                    <td>${addrList.contactNumber}</td>
                    <td><input type="radio" value="${addrList.addrId}">选择</td>
                </tr>
            </C:forEach>
        </table>
    </div>
</C:if>
</body>
<%@include file="../public/booter.jsp"%>
<script>
    function requestOrder() {
        post("loadUserAddress");
    }
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
