<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/10
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <font size="40px" color="crimson">昆明理工大学</font>
    <form action="/myWeb/login">
        <table border="1px">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"> </td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"> </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" name="登录" value="登录"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
