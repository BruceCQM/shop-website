<%@ page import="cn.bruce.dao.UserDao" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2020/11/13
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<h2 align="center"><span style="color: #ff0000; ">购物车</span></h2>
<div align="center">
    <p>
        <a href="/website/shopping.jsp"><input type="button" value="返回商城"></a>
    </p>
</div>

<form action="/website/totalServlet" method="post">
    <table border="1" align="center">
        <tr bgcolor="#CCCCCC">
            <td>
                &nbsp;商品编号&nbsp;
            </td>
            <td>
                &nbsp;商品名称&nbsp;
            </td>
            <td>
                &nbsp;商品价格￥&nbsp;
            </td>
            <td>
                &nbsp;确定购买&nbsp;
            </td>
        </tr>

        <%
            UserDao dao = new UserDao();
            List<Map<String, Object>> list = dao.showCart();
            for (Map<String, Object> stringObjectMap : list) {
        %>
        <tr>
            <%
                for (String s : stringObjectMap.keySet()) {
            %>
            <td>
                <%= stringObjectMap.get(s)%>
            </td>
            <%
                }
            %>
            <td>
                <input type="checkbox" name="buyId"
                       value="<%= stringObjectMap.get("id") %>">
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <div align="center">
        <p>
            <input type="reset" value="全部取消">
            &nbsp;&nbsp;
            <input type="submit" value="确定付款">
        </p>
    </div>
</form>

</body>
</html>
