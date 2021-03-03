package com.tide.service.impl;

import com.tide.dao.CategoryDao;
import com.tide.dao.impl.CategoryDaoImpl;
import com.tide.daomain.Category;
import com.tide.service.CategoryService;

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
        CategoryDao categoryDao = new CategoryDaoImpl();
        categoryDao.delete(cid);
    }
}
