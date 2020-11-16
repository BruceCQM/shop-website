<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2020/11/11
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>BruceCAI商城用户登录</title>
  </head>
  <body>

  <h2 align="center"><span style="color: #ff0000; ">欢迎登录BruceCAI商城</span></h2>
  <form action="/website/loginServlet" method="post">
    <table align="center" border="1">
      <tr>
        <td>用户名:</td>
        <td><input type="text" placeholder="请输入用户名" name="username"></td>
      </tr>
      <tr>
        <td>密&nbsp;&nbsp;码:</td>
        <td><input type="password" placeholder="请输入密码" name="password"></td>
      </tr>
    </table>
    <br>
    <div align="center">
      <input type="submit" value="登录">
      &nbsp;&nbsp;
      <input type="reset" value="重置">
      <p>
        <a href="/website/register.jsp"><input type="button" value="注册新用户"></a>
      </p>
    </div>
  </form>
  </body>
</html>
