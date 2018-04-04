package com.link;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 测试 Datasource
 *
 * @author link
 * @create 2018-04-04-7:31
 */
public class DataSourceTest {

    ApplicationContext context=null;

    @Before
    public void setContext(){
        context = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("setContext");
    }

    /**
     * 测试datasource
     */
    @Test
    public void dataSourceTest(){
        System.out.println("dataSourceTest");
        DataSource dataSource =  (DataSource)context.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }

    @After
    public void tearContext(){
        context=null;
        System.out.println("tearContext");
    }

    @Test
   public  void  jdbcTemplateTest(){
       System.out.println("jdbcTemplate");
        JdbcTemplate jdbcTemplate =  (JdbcTemplate)context.getBean("jdbcTemplate");
       Assert.assertNotNull(jdbcTemplate);
    }



}
