<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: WS
  Date: 2018/5/7
  Time: 7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功</title>
</head>
<body>
欢迎你！<br>
<shiro:hasRole name="teacher">【<shiro:principal/>】有‘teacher’角色</shiro:hasRole><br>
<shiro:hasPermission name="student:*">【<shiro:principal/>】有'student:*'权限</shiro:hasPermission><br>
<shiro:hasRole name="admin">【<shiro:principal/>】有‘admin’角色</shiro:hasRole><br>
<shiro:hasPermission name="user:*">【<shiro:principal/>】有'user:*'权限</shiro:hasPermission><br>
</body>
</html>
