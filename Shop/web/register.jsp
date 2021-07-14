<%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2020/11/11
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<h2 align="center"><span style="color: #ff0000; ">用户注册页面</span></h2>
<form action="/website/registerServlet" method="post">
    <table align="center" border="1">
        <tr>
            <td>用户名：</td>
            <td><input type="text" placeholder="请输入新用户名" name="username"></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码：</td>
            <td><input type="password" placeholder="请输入密码" name="password"></td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td><input type="password" placeholder="请再输入密码" name="password2"></td>
        </tr>
    </table>
    <br>
    <div align="center">
        <input type="submit" value="提交注册">
        &nbsp;&nbsp;
        <input type="reset" value="重置信息">
        &nbsp;&nbsp;
        <a href="/website/index.jsp"><input type="button" value="返回登录页面"></a>
    </div>
</form
</body>
</html>

<%--<script>--%>
<%--    //取出传回来的参数error并与yes比较--%>
<%--    var error ='<%=request.getParameter("errorMsg")%>';--%>
<%--    if(!error){--%>
<%--        alert("两次密码不同啊！");--%>
<%--    }--%>
<%--</script>--%>

