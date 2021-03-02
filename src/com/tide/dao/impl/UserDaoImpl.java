package com.tide.dao.impl;

import com.tide.dao.UserDao;
import com.tide.daomain.User;
import com.tide.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public User login(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 获得连接
            conn = JDBCUtils.getConnection();
            // sql
            String sql = "select * from user where username = ? and password = ?";
            // 预编译
            pstmt = conn.prepareStatement(sql);
            // 设置参数
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2, user.getPassword());
            rs = pstmt.executeQuery();

            if (rs.next()){
                User existUser = new User();
                existUser.setUid(rs.getInt("uid"));
                existUser.setUsername(rs.getString("username"));
                existUser.setPassword(rs.getString("password"));
                return existUser;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放
            JDBCUtils.release(rs,pstmt,conn);
        }
        return null;
    }
}
