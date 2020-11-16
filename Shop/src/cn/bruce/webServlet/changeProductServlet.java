package cn.bruce.webServlet;

import cn.bruce.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeProductServlet")
public class changeProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        if(request.getParameter("id").length() != 0){
            if(request.getParameter("info").length() != 0){
                //文本框都不为空才执行下面
                int oldId = Integer.parseInt(request.getParameter("id"));
                String item = request.getParameter("item");
                UserDao dao = new UserDao();
                if(dao.searchGood(oldId) == null){
                    response.setHeader("refresh","1.5;url='/website/changeProduct.jsp'");
                    response.getWriter().write("没有这件商品!请检查...");
                }
                else{
                    String info = request.getParameter("info");
                    //修改商品信息
                    dao.changeGoods(oldId,item,info);
                    //修改购物车里对应的商品信息
                    dao.changeCart(oldId,item,info);
                    //修改销售报表里对应的商品信息
                    dao.changeFinance(request.getParameter("id"),item,info);
                    response.setHeader("refresh","1.5;url='/website/changeProduct.jsp'");
                    response.getWriter().write("商品信息修改成功!");
                }
            }
            else{
                response.setHeader("refresh","1.5;url='/website/changeProduct.jsp'");
                response.getWriter().write("商品修改信息不能为空啊!");
            }
        }
        else{
            response.setHeader("refresh","1.5;url='/website/changeProduct.jsp'");
            response.getWriter().write("商品Id不能为空啊!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
