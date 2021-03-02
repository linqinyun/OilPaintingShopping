package com.tide.web.action;

import com.tide.daomain.Category;
import com.tide.service.CategoryService;
import com.tide.service.impl.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求路径
        String methodName = request.getParameter("method");
        if ("findAll".equals(methodName)){
            findAll(request,response);
        }
    }

    /**
     * 后台分类管理查询所有分类的方法：
     * @param request
     * @param response
     */
    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> list = categoryService.findAll();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
