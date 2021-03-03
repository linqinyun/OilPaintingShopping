package com.tide.dao;

import com.tide.daomain.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    void save(Category category);

    Category findOne(Integer cid);
}
