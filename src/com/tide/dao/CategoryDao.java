package com.tide.dao;

import com.tide.daomain.Category;

import java.sql.Connection;
import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    void save(Category category);

    Category findOne(Integer cid);

    void update(Category category);

    void delete(Integer cid);

    void delete(Connection conn, Integer cid);
}
