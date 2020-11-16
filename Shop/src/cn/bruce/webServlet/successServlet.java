package cn.bruce.webServlet;

import cn.bruce.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class successServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getAttribute("user");
        response.setContentType("text/html;charset=utf-8");
        if(user != null){
            if(!"admin".equals(user.getUsername()))
            {
                response.setHeader("refresh","2;url='/website/shopping.jsp'");
                response.getWriter().write("登陆成功！亲爱的 " + user.getUsername() + " 用户。正在进入商城页面,请稍等...");
            }
            else
            {
                response.setHeader("refresh","2;/website/admin.jsp");
                response.getWriter().write("管理员身份验证通过，正在进入商城后台页面...");
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
