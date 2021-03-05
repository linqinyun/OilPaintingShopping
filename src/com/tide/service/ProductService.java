package com.tide.service;

import com.tide.daomain.PageBean;
import com.tide.daomain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    void save(Product product);


    Product findOne(Integer pid);

    void update(Product product);

    void delete(Integer pid);

    PageBean<Product> findByPage(int page);
}
