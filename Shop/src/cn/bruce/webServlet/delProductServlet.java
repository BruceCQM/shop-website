package cn.bruce.webServlet;

import cn.bruce.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delProductServlet")
public class delProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectIds = request.getParameterValues("selectId");
        response.setContentType("text/html;charset=utf-8");
        if(selectIds != null){
            UserDao dao = new UserDao();
            for (String selectId : selectIds) {
                //删除商品表的商品
                dao.delGoods(Integer.parseInt(selectId));
                //删除购物车对应的商品
                dao.delCart(Integer.parseInt(selectId));
            }
            response.setHeader("refresh","1.5;url='/website/management.jsp'");
            response.getWriter().write("成功下架商品!");
        }
        else{
            response.setHeader("refresh","1.5;url='/website/management.jsp'");
            response.getWriter().write("请选择要下架的商品!");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
