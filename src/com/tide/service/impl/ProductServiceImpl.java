package com.tide.service.impl;

import com.tide.dao.ProductDao;
import com.tide.dao.impl.ProductDaoImpl;
import com.tide.daomain.PageBean;
import com.tide.daomain.Product;
import com.tide.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> findAll() {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        ProductDao productDao = new ProductDaoImpl();
        productDao.save(product);
    }

    @Override
    public Product findOne(Integer pid) {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.findOne(pid);
    }

    @Override
    public void update(Product product) {
        ProductDao productDao = new ProductDaoImpl();
        productDao.update(product);
    }

    @Override
    public void delete(Integer pid) {
        ProductDao productDao = new ProductDaoImpl();
        productDao.delete(pid);
    }

    @Override
    public PageBean<Product> findByPage(int page) {
        PageBean<Product> pageBean = new PageBean<Product>();
        pageBean.setPage(page);
        int limit = 6;
        pageBean.setLimit(limit);
        ProductDao productDao = new ProductDaoImpl();
        int totalCount = productDao.findCount();
        pageBean.setTotalCount(totalCount);
        int pageCount = 0;
        if (totalCount % limit == 0) {
            pageCount = totalCount / limit;
        } else {
            pageCount = totalCount / limit + 1;
        }
        pageBean.setTotalPage(pageCount);
        int begin = (page - 1) * limit;
        List<Product> list = productDao.findByPage(begin, limit);
        pageBean.setList(list);
        return pageBean;
    }

}
