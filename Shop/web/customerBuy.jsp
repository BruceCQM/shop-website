<%@ page import="cn.bruce.dao.UserDao" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2020/11/15
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户购买记录</title>
</head>
<body>
<h2 align="center"><span style="color: #ff0000; ">客户商品购买记录</span></h2>
<form method="post">
    <table border="1" align="center">
        <tr bgcolor="#CCCCCC">
            <td>
                &nbsp;顾客用户名&nbsp;
            </td>
            <td>
                &nbsp;商品编号&nbsp;
            </td>
            <td>
                &nbsp;商品名称&nbsp;
            </td>
            <td>
                &nbsp;商品价格&nbsp;
            </td>
            <td>
                &nbsp;购买时间&nbsp;
            </td>
        </tr>

        <%
            UserDao dao = new UserDao();
            List<Map<String, Object>> list = dao.showPurchase();
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
        </tr>
        <%
            }
        %>
    </table>
    <div align="center">
        <p>
            <a href="/website/admin.jsp"><input type="button" value="返回后台"></a>
        </p>
    </div>
</form>

</body>
</html>
