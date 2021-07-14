<%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2020/11/13
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<h2 align="center"><span style="color: #ff0000; ">添加商品目录</span></h2>
<form action="/website/addProductServlet" method="post">
    <table align="center" border="1">
        <tr>
            <td>商品编号：</td>
            <td><input type="text" name="id" placeholder="请输入商品编号"></td>
        </tr>
        <tr>
            <td>商品名称：</td>
            <td><input type="text" name="goodsname" placeholder="请输入商品名称"></td>
        </tr>
        <tr>
            <td>商品价格：</td>
            <td><input type="text" name="price" placeholder="请输入商品价格"></td>
        </tr>
    </table>
    <div align="center">
        <p>
            <input type="submit" value="确定添加">
            &nbsp;&nbsp;
            <input type="reset" value="重置信息">
            &nbsp;&nbsp;
            <a href="/website/management.jsp"><input type="button" value="返回目录"></a>
        </p>
    </div>
</form>

</body>
</html>
