package me.best.main.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class JdbcUtils {
    private static DataSource dataSource = null;
    static {
        dataSource = new ComboPooledDataSource("postgresql");
    }

    //获取连接对象
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭连接
    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    //事务回滚
    public static void rollBack(Connection conn){
        if(conn != null){
            try {
                conn.rollback();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}
