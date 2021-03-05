package com.tide.web.action;

import com.tide.daomain.Category;
import com.tide.daomain.PageBean;
import com.tide.daomain.Product;
import com.tide.service.CategoryService;
import com.tide.service.ProductService;
import com.tide.service.impl.CategoryServiceImpl;
import com.tide.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 0;
        String currPage = request.getParameter("page");
        if (currPage == null){
            page = 1;
        }else{
            page = Integer.parseInt(currPage);
        }
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categoryList =  categoryService.findAll();
        ProductService productService = new ProductServiceImpl();
        PageBean<Product> pageBean = productService.findByPage(page);

        request.setAttribute("categoryList",categoryList);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
