package cn.bruce.webServlet;

import cn.bruce.dao.UserDao;
import cn.bruce.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置数据格式和编码方式
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //response.setCharacterEncoding("utf-8");
        //输入信息不为空
        if(request.getParameter("username").length()!=0 && request.getParameter("password").length()!=0)
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");

            if(!password.equals(password2)){
                //设置refresh响应头，1.5秒后跳转回注册页面
                response.setHeader("refresh", "1.5;url='/website/register.jsp'");
                response.getWriter().write("两次密码输入不相同，客官请检查一下吧,正在返回注册页面...");
            }else{
                //讲用户名和密码封装成JavaBean
                User registerUser = new User();
                registerUser.setUsername(username);
                registerUser.setPassword(password);
                //创建UserDao对象调用方法进行数据库查询
                UserDao dao = new UserDao();
                int count = dao.register(registerUser);
                if(count == 1){
                    //返回登录页面
                    response.setHeader("refresh","1;url='/website/index.jsp'");
                    response.getWriter().write("注册成功啦!正在返回登录页面...");
                }
            }
        }
        else{
            response.setHeader("refresh","1;url='/website/register.jsp'");
            response.getWriter().write("用户名或密码不能为空哦!请检查一下吧...");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
