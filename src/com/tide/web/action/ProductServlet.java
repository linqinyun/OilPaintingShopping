package com.tide.web.action;

import com.tide.daomain.Category;
import com.tide.daomain.Product;
import com.tide.service.CategoryService;
import com.tide.service.ProductService;
import com.tide.service.impl.CategoryServiceImpl;
import com.tide.service.impl.ProductServiceImpl;
import com.tide.utils.UploadUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 参照后台分类管理创建
        String methodName = request.getParameter("method");
        if ("findAll".equals(methodName)) {
            findAll(request, response);
        } else if ("saveUI".equals(methodName)) {
            saveUI(request, response);
        } else if ("save".equals(methodName)) {
            save(request, response);
        } else if ("edit".equals(methodName)) {
            edit(request, response);
        } else if ("update".equals(methodName)) {
            update(request, response);
        } else if ("delete".equals(methodName)) {
            delete(request, response);
        }

    }

    /**
     * 后台商品管理商品删除
     *
     * @param request
     * @param response
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pid = Integer.parseInt(request.getParameter("pid"));
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findOne(pid);
        String path = product.getPath();
        if (path != null && !"".equals(path)) {
            this.getServletContext().getRealPath(path);
        }
        productService.delete(pid);
        response.sendRedirect(request.getContextPath() + "/ProductServlet?method=findAll");

    }

    /**
     * 后台商品管理修改方法
     *
     * @param request
     * @param response
     */
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> map = UploadUtils.uploadFile(request);
        Product product = new Product();
        product.setPid(Integer.parseInt(map.get("pid")));
        product.setPname(map.get("pname"));
        product.setAuthor(map.get("author"));
        product.setPrice(Double.parseDouble(map.get("price")));
        product.setDescription(map.get("description"));
        product.setFilename(map.get("filename"));
        product.setPath(map.get("path"));
        product.getCategory().setCid(Integer.parseInt(map.get("cid")));
        ProductService productService = new ProductServiceImpl();
        productService.update(product);
        response.sendRedirect(request.getContextPath() + "/ProductServlet?method=findAll");
    }

    /**
     * 后台商品修改页面
     *
     * @param request
     * @param response
     */
    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pid = Integer.parseInt(request.getParameter("pid"));
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findOne(pid);
        // 获取分类
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> list = categoryService.findAll();
        request.setAttribute("product", product);
        request.setAttribute("categoryList", list);
        request.getRequestDispatcher("/admin/product_update.jsp").forward(request, response);
    }

    /**
     * 后台商品管理保存商品
     *
     * @param request
     * @param response
     */
    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> map = UploadUtils.uploadFile(request);
        Product product = new Product();
        product.setPname(map.get("pname"));
        product.setAuthor(map.get("author"));
        product.setPrice(Double.parseDouble(map.get("price")));
        product.setDescription(map.get("description"));
        product.setFilename(map.get("filename"));
        product.setPath(map.get("path"));
        product.getCategory().setCid(Integer.parseInt(map.get("cid")));
        ProductService productService = new ProductServiceImpl();
        productService.save(product);

        response.sendRedirect(request.getContextPath() + "/ProductServlet?method=findAll");
    }

    /**
     * 后台商品添加页面显示，增加分类
     *
     * @param request
     * @param response
     */
    private void saveUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取分类
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> list = categoryService.findAll();
        request.setAttribute("categoryList", list);
        request.getRequestDispatcher("/admin/product_add.jsp").forward(request, response);
    }

    /**
     * 后台商品列表所有，不带任何参数
     *
     * @param request
     * @param response
     */
    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<Product> list = productService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/admin/product_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
