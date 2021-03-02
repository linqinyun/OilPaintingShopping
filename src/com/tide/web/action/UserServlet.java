package com.tide.web.action;

import com.tide.daomain.User;
import com.tide.service.UserService;
import com.tide.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        String methodName = request.getParameter("method");
        if("login".equals(methodName)){
            login(request,response);
        }
    }

    /**
     * UserServlet 登录方法
     * @param request
     * @param response
     */
    private void login(HttpServletRequest request,HttpServletResponse response){
        // 接受用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //数据封装
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //处理数据
        UserService userService = new UserServiceImpl();
        User existUser = userService.login(user);
        // 根据结果，完成也页面跳转
        if (existUser == null){
            // error
            request.setAttribute("msg","用户名或密码错误");
            try {
                request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            // success
            // 用户信息保存，页面跳转
            request.getSession().setAttribute("existUser",existUser);
            try {
                response.sendRedirect(request.getContextPath()+"/admin/category_list.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
