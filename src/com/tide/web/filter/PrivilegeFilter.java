package com.tide.web.filter;

import com.tide.daomain.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = {"/admin/*","/CategoryServlet","/ProductServlet"})
public class PrivilegeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 获得seeeion
        HttpServletRequest req = (HttpServletRequest) request;
        User existUser = (User) req.getSession().getAttribute("existUser");
        if (existUser == null){
            // 没有登录
            request.setAttribute("msg","您还未登陆，请先登陆后再访问！");
            request.getRequestDispatcher("/login.jsp").forward(req, response);
            return;
        }
        chain.doFilter(request, response);
    }
}
