<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: WS
  Date: 2018/5/14
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
${info}
欢迎你！
<shiro:hasRole name="admin">欢迎有admin角色的用户！<shiro:principal/></shiro:hasRole>
<shiro:hasPermission name="student:create">欢迎有student:create权限的用户！</shiro:hasPermission>
</body>
</html>
