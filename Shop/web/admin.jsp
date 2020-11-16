<%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2020/11/13
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员后台</title>
</head>
<body>
<h2 align="center"><span style="color: #ff0000; ">商城后台管理</span></h2>
<div align="center">
    <p>选择要进行的操作</p>
    <a href="/website/management.jsp"><input type="button" value="管理商品目录"></a>
    &nbsp;&nbsp;
    <a href="/website/finance.jsp"><input type="button" value="查看销售报表"></a>
    <br><br>
    <a href="/website/customerBuy.jsp"><input type="button" value="客户购买记录"></a>
    &nbsp;&nbsp;
    <a href="/website/index.jsp"><input type="button" value="退出登录用户"></a>
</div>
</body>
</html>
