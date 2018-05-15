package com.shiro.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by WS on 2018/5/11.
 */
public class DbUtils {

    public Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiro-test?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8  ", "root","ws199210");
        return conn;
    }

    public void closeCon(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
