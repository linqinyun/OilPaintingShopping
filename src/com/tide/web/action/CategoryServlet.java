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
        if ("findAll".equals(methodName)){ //查询全部分类
            findAll(request,response);
        }else if("saveUI".equals(methodName)){ //add页面
            saveUI(request,response);
        }
    }

    /**
     * 后台分类管理跳转添加页面
     * @param request
     * @param response
     */
    private void saveUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath()+"/admin/category_add.jsp").forward(request,response);
    }


    /**
     * 后台分类管理查询所有分类的方法：
     * @param request
     * @param response
     */
    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> list = categoryService.findAll();

        // 数据传入表现层
        request.setAttribute("list",list);
        request.getRequestDispatcher(request.getContextPath()+"/admin/category_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
