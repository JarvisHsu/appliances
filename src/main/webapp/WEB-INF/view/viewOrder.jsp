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

    .balance {
        width: 650px;
        background: rgba(0, 0, 0, 0.1);
        box-shadow: 0 15px 25px 0 rgba(0, 0, 0, 0.6);
        padding: 40px;
        z-index: 1;
        box-sizing: border-box;
    }
</style>
<body onload="payErrorMessage()">
<button style="position: absolute;bottom: 0;right: 0;width: 100px;
height: 40px;background: transparent;border-radius: 50px;cursor: pointer;outline: none;"
        onclick="post('indexView')">首页
</button>
<%--客户界面--%>
<C:if test="${sessionScope.UserInfo.roleId==1}">
    <C:if test="${requestScope.pageList==null}">
        <h2>您尚未拥有订单，或者加载失败，尝试刷新一下哦！</h2>
    </C:if>
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
<%--客服界面--%>
<C:if test="${sessionScope.UserInfo.roleId==2}">
    <C:if test="${requestScope.allUsersOrders!=null}">
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
                <C:forEach items="${requestScope.allUsersOrders}" var="pageList">
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
                                ${pageList.comment.substring(0,3)}...
                            </C:if>
                            <C:if test="${pageList.status!='5'}">
                                未评论
                            </C:if>
                        </td>
                        <C:if test="${pageList.status=='4'}">
                            <td><input type="radio" style="cursor: pointer;" name="sendent" value="${pageList.orderId}">分派
                            </td>
                        </C:if>
                        <C:if test="${pageList.status=='5'}">
                            <td><input type="radio" style="cursor: pointer;" name="detialComment"
                                       value="${pageList.comment}">详细
                            </td>
                        </C:if>
                    </tr>
                </C:forEach>
                <input type="button" id="detialComment" value="查看详细" style="cursor: pointer;">
                <input type="button" id="sendent" value="分派任务" style="cursor: pointer;">
            </table>
        </div>
    </C:if>
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
                "margin:0 auto 15px;display:block;font-size: xx-large;' required maxlength='100' minlength='20'>")
            var comBack = $("<input type='button' style='cursor: pointer' id='comBack' value='返回'>").click(function () {
                $(".comBoard").remove();
                $(".Orders").show();
            });
            var comCommit = $("<input type='button'style='cursor: pointer' id='comCommit' value='提交'>").click(function () {
                var comText = $("#comText").val();
                var comParam = [comment, comText];
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
            //输入密码登录账户模块
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
                $.post("checkPayAccount", {"userId": userId, "payPwd": payPwd, "orderId": pay}, function (data) {
                    if (data !== '0') {
                        var lastMoney = data.substring(0, data.indexOf(','));
                        var shouldPay = data.substring(data.indexOf(',') + 1, data.length);
                        $(".payBoard").hide();
                        //密码正确进入支付确认模块
                        var Balance = $("<div class='balance'>");
                        var h2 = $("<h2>");
                        h2.text("支付确认");
                        var tablePay = $("<table border='1' cellspacing='0'>");
                        var tr_one = $("<tr>");
                        var th_head1 = $("<th>");
                        var td_head1 = $("<td>");
                        var tr_two = $("<tr>");
                        var th_head2 = $("<th>");
                        var td_head2 = $("<td>");
                        var backPay = $("<input type='button' style='cursor: pointer' id='backPay' value='返回'>").click(function () {
                            $(".Balance").remove();
                            $(".payBoard").show();
                            input_pwd.val("");

                        });
                        var commitPay = $("<input type='button' style='cursor: pointer' id='commitPay' value='提交'>").click(function () {
                            var myOrderId = pay;
                            var myShouldPay = shouldPay;
                            var myUserId = userId;
                            var myLastMoney = lastMoney;
                            var payParam = [myOrderId, myShouldPay, myUserId, myLastMoney, payPwd]
                            post("payTheOrder", payParam);
                        });
                        td_head1.text(lastMoney + '元');
                        th_head1.text("账户余额");
                        th_head2.text("应付金额");
                        td_head2.text(shouldPay + '元');
                        tr_two.append(th_head2);
                        tr_two.append(td_head2);
                        tr_one.append(th_head1);
                        tr_one.append(td_head1);
                        tablePay.append(tr_one);
                        tablePay.append(tr_two);
                        Balance.append(backPay);
                        Balance.append(commitPay);
                        Balance.append(h2);
                        Balance.append(tablePay);
                        $("body").append(Balance);
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
    //客服调用查看评论详细模块
    $("#detialComment").click(function () {
        var detialList = document.getElementsByName("detialComment");
        var detialComment = null;
        for (var i = 0; i < detialList.length; i++) {
            if (detialList[i].checked === true) {
                detialComment = detialList[i].value;
            }
        }
        if (detialComment != null) {
            $(".Orders").hide();
            var comBoard = $("<div class='comBoard'>")
            var h2 = $("<h2>")
            h2.text("评论详细");
            var textarea = $("<textarea name='comText' id='comText' cols='40%' rows='10%' " +
                "autocomplete='off' style='background: transparent;outline: none;" +
                "margin:0 auto 15px;display:block;font-size: xx-large;' required maxlength='100' minlength='20'>")
            textarea.text(detialComment);
            var comBack = $("<input type='button' style='cursor: pointer' id='comBack' value='返回'>").click(function () {
                $(".comBoard").remove();
                $(".Orders").show();
            });
            comBoard.append(comBack);
            comBoard.append(h2);
            comBoard.append(textarea);
            $("body").append(comBoard);
        } else {
            alert("尚未选择！");
        }
    });
    $("#sendent").click(function () {
        var sendentList = document.getElementsByName("sendent");
        var sendent = null;
        for (var i = 0; i < sendentList.length; i++) {
            if (sendentList[i].checked === true) {
                sendent = sendentList[i].value;
            }
        }
        var userId = [];
        var userName = [];
        var userOrders = [];
        if (sendent != null) {
            $.post("loadFixer", function (data) {
                $.each(data, function (KEY, VALUE) {
                    $.each(VALUE, function (key, value) {
                        if (key === 'userId') {
                            userId.push(parseInt(value));
                        }
                        if (key === 'userName') {
                            userName.push(value);
                        }
                    });
                });
                $.post("loadFixerOrders", {'fixId': userId.join(',')}, function (data) {
                    $.each(data, function (KEY, VALUE) {
                        userOrders.push(VALUE);
                    });
                    $(".Orders").hide();
                    var Balance = $("<div class='balance'>");
                    var h2 = $("<h2>");
                    h2.text("分派任务");
                    var tablePay = $("<table border='1' cellspacing='0'>");
                    var tr_1 = $("<tr>");
                    var th_1 = $("<th>");
                    var th_2 = $("<th>");
                    th_1.text("维修人员");
                    th_2.text("当前单量");
                    tr_1.append(th_1).append(th_2);
                    tablePay.append(tr_1);
                    for (var i = 0; i < userName.length; i++) {
                        var tr_2 = $("<tr>");
                        var td_21 = $("<td>");
                        var td_22 = $("<td>");
                        var td_23 = $("<td>");
                        var input_1 = $("<input type='radio' style='cursor: pointer;' name='sendTo'>");
                        input_1.val(userId[i]);
                        td_23.append(input_1).append($("<p style='display: contents'>").text("分派"));
                        td_21.text(userName[i]);
                        td_22.text(userOrders[i]);
                        tr_2.append(td_21).append(td_22).append(td_23);
                        tablePay.append(tr_2);
                    }
                    var send_back = $("<input type='button' id='sendBack' value='返回' style='cursor: pointer'>").click(function () {
                        $(".Balance").remove();
                        $(".Orders").show();
                    });
                    var send_commit = $("<input type='button' id='sendCommit' value='提交' style='cursor: pointer'>").click(function () {
                        var radios_send_list = document.getElementsByName("sendTo");
                        var fixerId = null;
                        for (var i = 0; i < radios_send_list.length; i++) {
                            if (radios_send_list[i].checked === true) {
                                fixerId = radios_send_list[i].value;
                            }
                        }
                        if (fixerId != null) {
                            var senderId = "${sessionScope.UserInfo.userId}";
                            var sendOrderId = sendent;
                            var senderParam = [fixerId, senderId, sendOrderId];
                            post("updateFixSend", senderParam);
                        } else {
                            alert("尚未选择!");
                        }
                    });
                    $("body").append(Balance.append(send_back).append(send_commit).append(h2).append(tablePay));
                });
            });
        } else {
            alert("尚未选择！");
        }

    });

    function payErrorMessage() {
        if (${requestScope.payErrorMessage!=null}) {
            alert("${requestScope.payErrorMessage}");
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
