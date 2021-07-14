<%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2020/11/13
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
</head>
<body>
<h2 align="center"><span style="color: #ff0000; ">修改商品信息</span></h2>
<div align="center">
    <form action="/website/changeProductServlet" method="post">
        <p>
            需修改的商品Id号：<input type="text" name="id" placeholder="请输入需要修改的商品的ID">
        </p>
        <p>
            请选择要修改的信息：
            <select name="item">
                <option value="1">商品Id号</option>
                <option value="2">商品名称</option>
                <option value="3">商品价格</option>
            </select>
        </p>
        <p>
            请输入修改信息：
            <input type="text" name="info" placeholder="请输入信息">
        </p>
        <p>
            <input type="submit" value="确定修改">
            &nbsp;&nbsp;
            <a href="/website/management.jsp"><input type="button" value="返回目录"></a>
        </p>
    </form>
</div>

</body>
</html>
