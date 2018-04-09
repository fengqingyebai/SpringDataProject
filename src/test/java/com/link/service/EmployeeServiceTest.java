package com.link.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试事务
 *
 * @author link
 * @create 2018-04-09-7:55
 */
public class EmployeeServiceTest {
    private ApplicationContext context = null;
    private EmployeeService employeeService = null;

    @Before
    public void setContext() {
        context = new ClassPathXmlApplicationContext("bean-new.xml");
        employeeService = context.getBean(EmployeeService.class);
        System.out.println("setContext");
    }


    @After
    public void tearContext() {
        context = null;
        System.out.println("tearContext");
    }


    @Test
    public void testUpdate(){
        employeeService.updateEmployee(1,60);
    }


    @Test
    public void testDelete(){
        employeeService.deleteEmployee(7);
    }

}
