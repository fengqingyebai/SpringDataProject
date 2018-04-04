package com.link.utils;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 *
 * @author link
 * @create 2018-04-03-23:07
 */
public class JDBCUtils {


    public static Connection getConnection() throws Exception {

//        String url = "jdbc:mysql:///spring_data";
//        String user = "root";
//        String password = "123456";
//        String driverClass = "com.mysql.jdbc.Driver";

        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("jdbc.url");
        String user =properties.getProperty("jdbc.user");
        String password =properties.getProperty("jdbc.password");
                String driverClass=properties.getProperty("jdbc.driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;

    }


    /**
     * 关闭释放db相关的资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection){

        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
