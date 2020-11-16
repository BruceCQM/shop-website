package cn.bruce.webServlet;

import cn.bruce.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/totalServlet")
public class totalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        int total = 0;
        String[] buyIds = request.getParameterValues("buyId");
        if(buyIds != null){
            for (String buyId : buyIds) {
                if(buyId.length() != 0){
                    //获取cookie中的用户名
                    String username = null;
                    Cookie[] cookies = request.getCookies();
                    for (Cookie cookie : cookies) {
                        if("username".equals(cookie.getName())){
                            username = cookie.getValue();
                            break;
                        }
                    }
                    //查询商品信息
                    Map<String, Object> map = dao.searchGood(Integer.parseInt(buyId));
                    //获取当前系统时间作为购买时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String buyTime = sdf.format(date);
                    //添加购买记录
                    dao.addPurchase(username,map,buyTime);
                    //从购物车删除商品
                    dao.delCart(Integer.parseInt(buyId));
                    //更新销售报表
                    dao.updateFinance(buyId);
                    //计算总金额
                    total = total + (Integer) map.get("price");
                }
            }
        }

        response.setContentType("text/html;charset=utf-8");
        if(total == 0){
            response.getWriter().write("生活不易,请选择您要下单的商品嘛~~");
            response.setHeader("refresh","1;url='/website/cart.jsp'");
        }
        else{
            response.getWriter().write("您本次的订单总金额为 "+total+" 元,正在付款,请稍等...");
            response.setHeader("refresh","2;url='/website/delCartServlet'");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
