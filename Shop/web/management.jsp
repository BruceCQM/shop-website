<%@ page import="cn.bruce.dao.UserDao" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2020/11/13
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品目录管理</title>
</head>
<body>
<h2 align="center"><span style="color: #ff0000; ">商品目录管理</span></h2>
<form action="/website/delProductServlet" method="post">
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
                &nbsp;选择删除&nbsp;
            </td>
        </tr>

        <%
            UserDao dao = new UserDao();
            List<Map<String, Object>> list = dao.showGoods();
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
                <input type="checkbox" name="selectId"
                       value="<%= stringObjectMap.get("id") %>">
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <div align="center">
        <p>
            <a href="/website/addProduct.jsp"><input type="button" value="添加商品"></a>
            &nbsp;&nbsp;
            <input type="submit" value="下架所选商品">
        </p>
        <p>
            <a href="/website/changeProduct.jsp"><input type="button" value="修改商品"></a>
            &nbsp;&nbsp;
            <input type="reset" value="取消选择">
            &nbsp;&nbsp;
            <a href="/website/admin.jsp"><input type="button" value="返回后台"></a>
        </p>
    </div>
</form>

</body>
</html>
