package com.tide.dao.impl;

import com.tide.dao.CategoryDao;
import com.tide.daomain.Category;
import com.tide.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> findAll() {

        List<Category> list = new ArrayList<Category>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from category";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setCname(rs.getString("cname"));
                category.setCdesc(rs.getString("cdesc"));
                list.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,pstmt,conn);
        }

        return list;
    }

    @Override
    public void save(Category category) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into category values (null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,category.getCname());
            pstmt.setString(2,category.getCdesc());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(pstmt,conn);
        }
    }

    @Override
    public Category findOne(Integer cid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from category where cid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,cid);
            rs = pstmt.executeQuery();
            if (rs.next()){
                Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setCname(rs.getString("cname"));
                category.setCdesc(rs.getString("cdesc"));
                return category;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,pstmt,conn);
        }
        return null;
    }

    @Override
    public void update(Category category) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "update category set cname=?,cdesc=? where cid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,category.getCname());
            pstmt.setString(2,category.getCdesc());
            pstmt.setInt(3,category.getCid());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(pstmt,conn);
        }
    }

    @Override
    public void delete(Integer cid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from category where cid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,cid);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(pstmt,conn);
        }
    }

    @Override
    public void delete(Connection conn, Integer cid) {

        PreparedStatement pstmt = null;
        try {
            String sql = "delete from category where cid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,cid);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
