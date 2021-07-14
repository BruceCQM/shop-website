package cn.bruce.webServlet;

import cn.bruce.dao.UserDao;
import cn.bruce.domain.Goods;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addProductServlet")
public class addProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if(request.getParameter("id").length()!=0 && request.getParameter("goodsname").length()!=0 && request.getParameter("price").length()!=0)
        {
            Goods goods = new Goods();
            try {
                //获取请求参数,封装为Map
                Map<String, String[]> map = request.getParameterMap();
                //封装参数为Goods
                BeanUtils.populate(goods,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            UserDao dao = new UserDao();
            dao.addGoods(goods);
            response.setHeader("refresh","1.5;url='/website/addProduct.jsp'");
            response.getWriter().write("商品添加成功！");
        }
        else
        {
            response.setHeader("refresh","1.5;url='/website/addProduct.jsp'");
            response.getWriter().write("商品信息不能为空！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
