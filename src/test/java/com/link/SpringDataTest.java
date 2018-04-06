package com.link;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * springData单元测试
 *
 * @author link
 * @create 2018-04-06-11:46
 */
public class SpringDataTest {

    private ApplicationContext context=null;
    @Before
    public void setContext(){
        context = new ClassPathXmlApplicationContext("bean-new.xml");

        System.out.println("setContext");
    }

    /**
     * 测试EntityManagerFactory
     */
    @Test
    public void testEntityManagerFactory(){

    }

    @After
    public void tearContext(){
        context=null;
        System.out.println("tearContext");
    }
}
