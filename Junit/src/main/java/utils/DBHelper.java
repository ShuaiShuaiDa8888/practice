package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC连接数据库
 *
 * Created by weishuai on 2018/2/13.
 */
public class DBHelper {
    public static final String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp&characterEncoding=utf-8&serverTimezone=GMT";
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "ws199210";

    public Connection connection = null;
    public PreparedStatement ps = null;

    public DBHelper(String sql) throws SQLException {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            ps = connection.prepareStatement(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            this.connection.close();
            this.ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
