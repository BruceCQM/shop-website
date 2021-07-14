<%@ page import="cn.bruce.dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2020/11/12
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BruceCAI商城</title>
</head>
<body>
<%
    String price1 = request.getParameter("price1");
    String price2 = request.getParameter("price2");
%>

<h2 align="center"><span style="color: #ff0000; ">请随意挑选</span></h2>
<div align="center">
    <p>
        <a href="/website/index.jsp"><input type="button" value="注销用户"></input></a>
        &nbsp;&nbsp;
        <a href="/website/cart.jsp"><input type="button" value="查看购物车"></a>
    </p>
    <form action="/website/shopping.jsp" method="post">
        请输入想要的价格范围：<input type="text" name="price1" style="width: 50px">&nbsp;~&nbsp;<input type="text" name="price2" style="width: 50px">
        &nbsp;&nbsp;
        <input type="submit" value="查询">
    </form>
</div>


<form action="/website/addCartServlet" method="post">
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
                &nbsp;添加到购物车&nbsp;
            </td>
        </tr>

        <%
            UserDao dao = new UserDao();
            List<Map<String, Object>> list = null;
            //有价格范围
            if(price1 != null && price2 != null){
                try {
                    int p1 = Integer.parseInt(price1);
                    int p2 = Integer.parseInt(price2);
                    //大小不对就交换一下
                    if(p1 > p2){
                        p1 = p1 ^ p2;
                        p2 = p1 ^ p2;
                        p1 = p1 ^ p2;
                    }
                    //查询价格范围内的商品
                    list = dao.searchGood(p1, p2);
                } catch (NumberFormatException e) {
                    //价格格式不正确输出所有信息
                    list = dao.showGoods();
                }
            }
            //无价格范围
            else{
                list = dao.showGoods();
            }

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
                <input type="checkbox" name="productId"
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
            <input type="submit" value="确定加入">
        </p>
    </div>
</form>

</body>
</html>
