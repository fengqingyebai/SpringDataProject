package com.link.utils;


import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试JDBC工具类
 *
 * @author link
 * @create 2018-04-03-23:20
 */
public class JDBCUtilsTest {

    @Test
    public void testGetConnection() throws Exception {

        Connection connection = JDBCUtils.getConnection();

        Assert.assertNotNull(connection);
    }



}
