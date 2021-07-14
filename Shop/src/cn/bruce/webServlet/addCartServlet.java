package cn.bruce.webServlet;

import cn.bruce.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addCartServlet")
public class addCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String[] productIds = request.getParameterValues("productId");
        UserDao dao = new UserDao();
        if(productIds != null){
            for (String id : productIds) {
                if(id.length() != 0){
                    Map<String, Object> map = dao.searchGood(Integer.parseInt(id));
                    dao.addCart(map);
                }
            }
            response.getWriter().write("添加成功啦!正在进入您的购物车...");
            response.setHeader("refresh","1.5;url='/website/cart.jsp'");
        }
        else{
            response.getWriter().write("生活不易,求求你加一些商品到购物车嘛,总有你喜欢的商品...");
            response.setHeader("refresh","1.5;url='/website/shopping.jsp'");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
