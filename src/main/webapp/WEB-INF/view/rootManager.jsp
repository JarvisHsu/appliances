<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>欢迎您,${sessionScope.UserInfo.userName}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/CommonStyle.css">
</head>
<style>

</style>
<body>
<c:if test="${sessionScope.UserInfo.roleId!=4}">
    <h2>您不是管理员，请<p onclick="post('getUserInfo')">返回</p></h2>
</c:if>
<%--技工列表--%>
<c:if test="${requestScope.fixerList}">

</c:if>
<%--客服列表--%>
<c:if test="${requestScope.serviceList}">

</c:if>
</body>
<script>

</script>
</html>
