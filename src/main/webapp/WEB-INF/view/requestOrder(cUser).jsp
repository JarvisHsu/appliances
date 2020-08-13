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

    .goods {
        width: 650px;
        background: rgba(0, 0, 0, 0.1);
        box-shadow: 0 15px 25px 0 rgba(0, 0, 0, 0.6);
        padding: 40px;
        z-index: 1;
        box-sizing: border-box;
    }

    .address {
        width: 650px;
        background: rgba(0, 0, 0, 0.1);
        box-shadow: 0 15px 25px 0 rgba(0, 0, 0, 0.6);
        padding: 40px;
        z-index: 1;
        box-sizing: border-box;
    }

    table {
        width: 100%;
        height: auto;
    }

    th, td, tr {
        text-align: center;
    }

    tr {
        line-height: 30px;
    }

    h2 {
        text-align: center;
        color: #ffffff;
        margin-bottom: 30px;
        cursor: default;
    }
</style>
<body onload="error()">
<C:if test="${requestScope.goodsList!=null}">
    <div class="goods">
        <h2>请选择需要维修的产品</h2>
        <table border="1" cellspacing="0">
            <tr>
                <th>产品Id</th>
                <th>产品名称</th>
                <th>产品信息</th>
            </tr>
            <C:forEach items="${requestScope.goodsList}" var="goodsList">
                <tr>
                    <td>${goodsList.goodsId}</td>
                    <td>${goodsList.goodsName}</td>
                    <td>${goodsList.goodsInfo}</td>
                    <td><input id="goodsId"
                               style="background: rgba(255,255,255,0.2);border-radius: 10px;outline: none;
                               cursor: pointer;" type="radio" name="goodsIdCheck"
                               value="${goodsList.goodsId}">请求订单
                    </td>
                </tr>
            </C:forEach>
            <input id="back1" type="button" value="返回">
            <input id="next1" type="button" value="下一步">
        </table>
    </div>
</C:if>
<C:if test="${requestScope.userAddrList!=null}">
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
            <C:forEach items="${requestScope.userAddrList}" var="addrList">
                <tr>
                    <td hidden>${addrList.addrId}</td>
                    <td>${addrList.province}</td>
                    <td>${addrList.city}</td>
                    <td>${addrList.area}</td>
                    <td>${addrList.address}</td>
                    <td>${addrList.contactNumber}</td>
                    <td><input id="addrId" type="radio" name="addrIdCheck" value="${addrList.addrId}">选择</td>
                </tr>
            </C:forEach>
            <input id="back2" type="button" value="返回">
            <input id="next2" type="button" value="下一步">
        </table>
    </div>
</C:if>
<C:if test="${requestScope.address!=null&&requestScope.goods!=null&&requestScope.order!=null}">
    <div class="address">
        <h2>请确认订单</h2>
        <table border="1" cellspacing="0">
            <tr>
                <th>用户信息</th>
                <td>用户名称:${sessionScope.UserInfo.userName},联系电话:${requestScope.address.contactNumber}</td>
            </tr>
            <tr>
                <th>维修地址</th>
                <td>${requestScope.address.province}${requestScope.address.city}${requestScope.address.area}${requestScope.address.address}</td>
            </tr>
            <tr>
                <th>维修产品</th>
                <td>产品名称:${requestScope.goods.goodsName},维修预计价格:${requestScope.order.price}元</td>
            </tr>
            <tr>
                <th>订单状态</th>
                <td><C:if test="${requestScope.order.status=='3'}">
                    未支付
                </C:if>
                    <C:if test="${requestScope.order.status=='2'}">
                        正在进行
                    </C:if>
                    <C:if test="${requestScope.order.status=='1'}">
                        已完成
                    </C:if>
                    <C:if test="${requestScope.order.status=='0'}">
                        已废弃
                    </C:if></td>
            </tr>
            <input id="cancel" type="button" value="取消订单">
            <input id="commit" type="button" value="确认订单">
        </table>
    </div>
</C:if>

</body>
<%@include file="../public/booter.jsp" %>
<script>
    $("#back1").click(function () {
        post("getUserInfo")
    });
    //提交产品
    $("#next1").click(function () {
        radios = document.getElementsByName("goodsIdCheck");
        var goodsId = null;
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].checked === true) {
                goodsId = radios[i].value;
            }
        }
        if (goodsId != null) {
            var params = [goodsId];
            post("loadUserAddress", params);
        } else {
            alert("请选择产品!")
        }
    })
    //提交地址
    $("#back2").click(function () {
        post("loadUserGoods");
    });
    $("#next2").click(function () {
        radios = document.getElementsByName("addrIdCheck");
        var addrId = null;
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].checked === true) {
                addrId = radios[i].value;
            }
        }
        if (addrId != null) {
            var param = [addrId];
            post("createOrder", param);
        } else {
            alert("请选择地址!");
        }
    });
    //取消订单
    $("#cancel").click(function () {
        var parames = ['0',${requestScope.order.orderId}]
        post("cancelAnOrder",parames);
    });
    $("#commit").click(function () {
        post("getUserInfo");
    });

    function error() {
        if (${requestScope.ErrorMessage!=null}) {
            alert("${requestScope.ErrorMessage},即将返回首页");
            post("getUserInfo")
        }
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
