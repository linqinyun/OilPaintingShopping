package com.tide.dao.impl;

import com.tide.dao.CategoryDao;
import com.tide.daomain.Category;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> findAll() {
        System.out.println("findAll方法执行");
        return null;
    }
}
