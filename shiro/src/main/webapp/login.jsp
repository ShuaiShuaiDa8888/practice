<%--
  Created by IntelliJ IDEA.
  User: WS
  Date: 2018/5/7
  Time: 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="login" method="post">
        userName:<input type="text" name="userName" value=""><br>
        password:<input type="password" name="password" value=""><br>
        <input type="submit" value="提交"><font color="red">${error}</font>
    </form>
</body>
</html>
