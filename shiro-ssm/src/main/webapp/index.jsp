<%--
  Created by IntelliJ IDEA.
  User: WS
  Date: 2018/5/13
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/api/1.0/login" method="post">
    userName:<input type="text" name="userName" value="${user.userName}"/><br>
    password:<input type="password" name="password" value="${user.password}"/><br>
    <input type="submit" value="login"><font color="red">${errorMsg}</font>
</form>
</body>
</html>
