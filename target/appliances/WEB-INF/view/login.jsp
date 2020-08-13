<%@ page isELIgnored="false" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Login</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Image/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/LoginTable/LoginStyle.css">
</head>
<body >
<div id="top-image">
</div>
<div class="LoginBox">
    <h2>家电售后服务平台</h2>
    <form action="loginHandler" method="post">
        <div class="item">
            <input id="user_id" type="text" required name="UserId" value="1001" autocomplete="off">
            <label>UserId</label>
        </div>
        <div class="item" id="password-label">
            <input id="password" type="password" required name="userPwd" value="123" autocomplete="off">
            <label>PassWord</label>
        </div>
        <div class="item" id="div_captcha">
            <input id="cap_input" type="text" required name="Captcha" value="" autocomplete="off">
            <label>Captcha</label>
            <a href="#" id="touch"><img id="captcha_img" src="getCaptcha" alt=""></a>
        </div>
        <button class="btn" value="">submit
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </button>
        <p id="loginError" style='display: inline;margin-left: 25px;color: red;'>${requestScope.loginError}</p>
    </form>
    <p id="register"><a href="#" onclick="error()">Create a new account for free</a></p>
</div>
</body>
<script>window.jQuery || document.write('<script src="/jQuery/jquery-1.11.0.min.js"><\/script>')</script>
<script>
    $("#cap_input").blur(function () {
       var captcha = this.value;
       $.post("checkCaptcha",{"captcha":captcha},function (data) {
           var log_message = $("<p id='log_message' style='display: inline;margin-left: 25px;'>");
           if (data === '0') {
               log_message.css("color", "red").text("验证码错误");
           } else {
               log_message.css("color", "green").text("验证码正确");
           }
           if ($("#loginError").text() !== '') {
               $("#loginError").remove();
           }
           if ($("#log_message").text() !== '') {
               $("#log_message").remove();
           }
           $(".btn").after(log_message);
           if ($("#log_message").text() === '验证码错误' || $("#log_message").text() === '用户名或密码错误') {
               $("#captcha_img").attr("src", "/getCaptcha?" + new Date().getTime());
           }
       });
    });
    function error() {
        alert("暂未开通注册业务！")
    }

    $("#touch").click(function () {
         $("#captcha_img").attr("src", "/getCaptcha?" + new Date().getTime());
    });

    $(document).ready(function () {
        $("#top-image").iosParallax({
            movementFactor: 50
        });
    });
    window.addEventListener("keydown", function (event) {
        if (event.defaultPrevented) {
            return; // Should do nothing if the default action has been cancelled
        }
        var handled = false;
        var code;
        //Get The Value Entered By The Keyboard
        if (event.key !== undefined) {
            // Handle the event with KeyboardEvent.key and set handled true.
            code = event.key;
        } else if (event.keyIdentifier !== undefined) {
            // Handle the event with KeyboardEvent.key and set handled true.
            code = event.keyIdentifier;
        } else if (event.keyCode !== undefined) {
            // Handle the event with KeyboardEvent.key and set handled true.
            code = event.keyCode;
        }
        if (code === "Enter") {
            checkLogin();
            handled = true;
        }
        if (handled) {
            // Suppress "double action" if event handled
            event.preventDefault();
        }
    }, true);
</script>
</html>
<%@include file="/WEB-INF/public/booter.jsp"%>