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
        if ("findAll".equals(methodName)) {
            //查询全部分类
            findAll(request, response);
        } else if ("saveUI".equals(methodName)) {
            //saveUI页面
            saveUI(request, response);
        } else if ("save".equals(methodName)) {
            //添加
            save(request, response);
        } else if ("edit".equals(methodName)) {
            // 编辑分类
            edit(request, response);
        }else if ("update".equals(methodName)){
            // 修改
            update(request,response);
        }else if ("delete".equals(methodName)){
            // 删除--硬删除
            delete(request,response);
        }
    }

    /**
     * 后台删除分类的方法
     * @param request
     * @param response
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer cid = Integer.parseInt(request.getParameter("cid"));
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.delete(cid);

        response.sendRedirect(request.getContextPath() + "/CategoryServlet?method=findAll");
    }

    /**
     * 后台修改分类
     * @param request
     * @param response
     */
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer cid = Integer.parseInt(request.getParameter("cid"));
        String cname = request.getParameter("cname");
        String cdesc = request.getParameter("cdesc");
        Category category = new Category();
        category.setCid(cid);
        category.setCname(cname);
        category.setCdesc(cdesc);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.update(category);
        response.sendRedirect(request.getContextPath() + "/CategoryServlet?method=findAll");
    }

    /**
     * 后台分类管理编辑分类
     *
     * @param request
     * @param response
     */
    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer cid = Integer.parseInt(request.getParameter("cid"));
        CategoryService categoryService = new CategoryServiceImpl();
        Category category = categoryService.findOne(cid);
        request.setAttribute("category",category);
        request.getRequestDispatcher("/admin/category_update.jsp").forward(request,response);
    }

    /**
     * 后台分类保存数据
     *
     * @param request
     * @param response
     */
    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cname = request.getParameter("cname");
        String cdesc = request.getParameter("cdesc");
        Category category = new Category();
        category.setCname(cname);
        category.setCdesc(cdesc);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.save(category);
        response.sendRedirect(request.getContextPath() + "/CategoryServlet?method=findAll");
    }

    /**
     * 后台分类管理跳转添加页面
     *
     * @param request
     * @param response
     */
    private void saveUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/admin/category_add.jsp").forward(request, response);
    }


    /**
     * 后台分类管理查询所有分类的方法：
     *
     * @param request
     * @param response
     */
    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> list = categoryService.findAll();

        // 页面跳转
        request.setAttribute("list", list);
        request.getRequestDispatcher(request.getContextPath() + "/admin/category_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
