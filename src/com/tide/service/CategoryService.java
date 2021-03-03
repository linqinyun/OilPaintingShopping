package com.tide.service;

import com.tide.daomain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findOne(Integer cid);

    void update(Category category);

    void delete(Integer cid);
}
