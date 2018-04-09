<%--
  Created by IntelliJ IDEA.
  User: WS
  Date: 2018/3/27
  Time: 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>上传1</h1><br>
<form action="/uploadServlet" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br>
    照  片：<input type="file" name="zhaopian"/><br>
    上  传：<input type="submit" value="上传">
</form>
</body>
</html>
