<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%--用户查看订单然后进行评论或者付费,客服查看订单进行分派，维修工查看订单进行完成操作。--%>
    <title>${sessionScope.UserInfo.userName}正在查看订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/CommonStyle.css">
</head>
<style>
    input {
        background: transparent;
        outline: none;
    }

    .Orders {
        width: 1000px;
        background: rgba(0, 0, 0, 0.1);
        box-shadow: 0 15px 25px 0 rgba(0, 0, 0, 0.6);
        padding: 40px;
        z-index: 1;
        box-sizing: border-box;
    }

    td {
        font-size: 20px;
    }

    .comBoard {
        width: 650px;
        background: rgba(0, 0, 0, 0.1);
        box-shadow: 0 15px 25px 0 rgba(0, 0, 0, 0.6);
        padding: 40px;
        z-index: 1;
        box-sizing: border-box;
    }

    .payBoard {
        width: 650px;
        background: rgba(0, 0, 0, 0.1);
        box-shadow: 0 15px 25px 0 rgba(0, 0, 0, 0.6);
        padding: 40px;
        z-index: 1;
        box-sizing: border-box;
    }

    .payUserInput {
        border: none;
        border-bottom: 1px solid black;
        margin: 0 auto 40px;
        font-size: 26px;
        display: block;
    }

    .payUserButton {
        width: 100px;
        height: 40px;
        border-radius: 20px;
        background: linear-gradient(30deg, #E6E6E6, #F8E0E0, #CECEF6, #BDBDBD, #F3F781);
        cursor: pointer;
    }
</style>
<body>
<C:if test="${sessionScope.UserInfo.roleId==1}">
    <C:if test="${requestScope.pageList!=null}">
        <div class="Orders">
            <h2>订单列表</h2>
            <table border="1" cellspacing="0">
                <tr>
                    <th>用户名称</th>
                    <th>维修产品</th>
                    <th>维修价格</th>
                    <th>当前状态</th>
                    <th>维修师傅</th>
                    <th>处理客服</th>
                    <th>评论信息</th>
                </tr>
                <C:forEach items="${requestScope.pageList}" var="pageList">
                    <tr>
                        <td>${pageList.client.userName}</td>
                        <td>${pageList.goods.goodsName}</td>
                        <td>${pageList.price}</td>
                        <td><C:if test="${pageList.status=='5'}">
                            已评论
                        </C:if>
                            <C:if test="${pageList.status=='4'}">
                                正在进行
                            </C:if>
                            <C:if test="${pageList.status=='3'}">
                                未支付
                            </C:if>
                            <C:if test="${pageList.status=='2'}">
                                已派单
                            </C:if>
                            <C:if test="${pageList.status=='1'}">
                                已完成
                            </C:if>
                            <C:if test="${pageList.status=='0'}">
                                已废弃
                            </C:if></td>
                        <td><c:if test="${pageList.fixId==null&&pageList.status!='0'}">
                            等待指派
                        </c:if>
                            <c:if test="${pageList.status=='0'}">
                                -
                            </c:if>
                                ${pageList.fixer.userName}</td>
                        <td><C:if test="${pageList.senderId==null&&pageList.status!='0'}">
                            等待处理
                        </C:if>
                            <c:if test="${pageList.status=='0'}">
                                -
                            </c:if>
                                ${pageList.sender.userName}</td>
                        <td style="width: 100px;">
                            <C:if test="${pageList.status=='5'}">
                                ${pageList.comment}
                            </C:if>
                            <C:if test="${pageList.status!='5'}">
                                未评论
                            </C:if>
                        </td>
                        <C:if test="${pageList.status=='1'}">
                            <td><input type="radio" style="cursor: pointer;" name="comment" value="${pageList.orderId}">评论
                            </td>
                        </C:if>
                        <C:if test="${pageList.status=='3'}">
                            <td><input type="radio" style="cursor: pointer;" name="pay" value="${pageList.orderId}">付费
                            </td>
                        </C:if>
                    </tr>
                </C:forEach>
                <input type="button" id="comment" value="去评论" style="cursor: pointer;">
                <input type="button" id="pay" value="去支付" style="cursor: pointer;">
            </table>
        </div>
    </C:if>
</C:if>
<C:if test="${sessionScope.UserInfo.roleId==2}">

</C:if>
</body>
<%@include file="../public/booter.jsp" %>
<script>
    //用户调用评论模块
    $("#comment").click(function () {
        var commentList = document.getElementsByName("comment");
        var comment = null;
        for (var i = 0; i < commentList.length; i++) {
            if (commentList[i].checked === true) {
                comment = commentList[i].value;
            }
        }
        if (comment != null) {
            $(".Orders").hide();
            var comBoard = $("<div class='comBoard'>")
            var h2 = $("<h2>")
            h2.text("评论板");
            var textarea = $("<textarea name='comText' id='comText' cols='40%' rows='10%' " +
                "autocomplete='off' style='background: transparent;outline: none;" +
                "margin:0 auto 15px;display:block;font-size: xx-large;' required>")
            var comBack = $("<input type='button' id='comBack' value='返回'>").click(function () {
                $(".comBoard").remove();
                $(".Orders").show();
            });
            var comCommit = $("<input type='button' id='comCommit' value='提交'>").click(function () {
                var comText = $("#comText").val();
                var comParam = [comment, comText];
                console.log(comParam);
                post("addAComment", comParam);
            });
            comBoard.append(comBack);
            comBoard.append(comCommit);
            comBoard.append(h2);
            comBoard.append(textarea);
            $("body").append(comBoard);
        } else {
            alert("还未选择!");
        }
    });
    //用户调用支付模块
    $("#pay").click(function () {
        var payList = document.getElementsByName("pay");
        var pay = null;
        for (var i = 0; i < payList.length; i++) {
            if (payList[i].checked === true) {
                pay = payList[i].value;
            }
        }
        if (pay != null) {
            $(".Orders").hide();
            var payBoard = $("<div class='payBoard'>");
            var h2 = $("<h2>");
            h2.text("登录您的账户");
            var input_user = $("<input class='payUserInput' id='userId' type='text' required name='userId' value='${sessionScope.UserInfo.userId}' placeholder='AccountId' autocomplete='off'>");
            var input_pwd = $("<input class='payUserInput' id='payPwd' type='password' required name='payPwd' placeholder='AccountPwd' autocomplete='off'>")
            var payBack = $("<input class='payUserButton' type='button' id='payBack' value='返回'>").click(function () {
                $(".payBoard").remove();
                $(".Orders").show();
            });
            var payCommit = $("<input class='payUserButton' style='margin-right: 50px;' type='button' id='payCommit' value='提交'>").click(function () {
                var userId = $("#userId").val();
                var payPwd = $("#payPwd").val();
                $.post("checkPayAccount", {"userId": userId, "payPwd": payPwd}, function (data) {
                    if (data === '1') {

                    } else {
                        alert("用户名或密码错误");
                    }
                });
            });
            var option = $("<div style='width: 250px;margin: 10px auto 15px;'>")
            option.append(payCommit);
            option.append(payBack);
            payBoard.append(h2);
            payBoard.append(input_user);
            payBoard.append($("<br>"))
            payBoard.append(input_pwd);
            payBoard.append(option);
            $("body").append(payBoard);
        } else {
            alert("请选择支付项！");
        }
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
