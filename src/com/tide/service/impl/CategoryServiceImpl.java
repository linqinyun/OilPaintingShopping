package com.tide.service.impl;

import com.tide.dao.CategoryDao;
import com.tide.dao.ProductDao;
import com.tide.dao.impl.CategoryDaoImpl;
import com.tide.dao.impl.ProductDaoImpl;
import com.tide.daomain.Category;
import com.tide.daomain.Product;
import com.tide.service.CategoryService;
import com.tide.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        // 调用dao
        CategoryDao categoryDao = new CategoryDaoImpl();
        return categoryDao.findAll();
    }

    @Override
    public void save(Category category) {
        CategoryDao categoryDao = new CategoryDaoImpl();
        categoryDao.save(category);
    }

    @Override
    public Category findOne(Integer cid) {
        CategoryDao categoryDao = new CategoryDaoImpl();
        return categoryDao.findOne(cid);
    }

    @Override
    public void update(Category category) {
        CategoryDao categoryDao = new CategoryDaoImpl();
        categoryDao.update(category);
    }

    @Override
    public void delete(Integer cid) {
        /**
         * 事务处理
         */
        Connection conn = null;
        try{
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            ProductDao productDao = new ProductDaoImpl();
            List<Product> list = productDao.findByCid(cid);
            for (Product product:list){
                product.getCategory().setCid(null);
                productDao.update(conn,product);
            }

            //删除
            CategoryDao categoryDao = new CategoryDaoImpl();
            categoryDao.delete(conn,cid);
            // 提交事务
            conn.commit();
        }catch (Exception e){
            // 回滚
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();

        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
