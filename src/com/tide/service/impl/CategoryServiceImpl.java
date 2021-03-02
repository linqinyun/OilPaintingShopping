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
}
