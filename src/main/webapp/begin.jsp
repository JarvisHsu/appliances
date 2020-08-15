<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自动跳转</title>
</head>
<body>
<p hidden>
    离自动跳转还有
<p hidden id="Time">1</p>
<p hidden>S</p>
</p>
</body>
<script>
    //使用匿名函数方法
    function countDown() {
        var time = document.getElementById("Time");
        //获取到id为time标签中的内容，现进行判断
        if (time.innerHTML <= 1) {
            //等于0时清除计时
            post("indexView")
            // window.location.href="https://www.baidu.com";
            // rel="external nofollow" ;
        } else {
            time.innerHTML = time.innerHTML - 1;
        }
    }

    //1000毫秒调用一次
    window.setInterval("countDown()", 1000);

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
