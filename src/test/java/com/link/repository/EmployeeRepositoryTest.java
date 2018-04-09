package com.link.repository;


import com.link.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * springdata测试
 *
 * @author link
 * @create 2018-04-08-23:17
 */
public class EmployeeRepositoryTest {

    private ApplicationContext context = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setContext() {
        context = new ClassPathXmlApplicationContext("bean-new.xml");
        employeeRepository = context.getBean(EmployeeRepository.class);
        System.out.println("setContext");
    }

    /**
     * 测试EntityManagerFactory
     */
    @Test
    public void testFindByName() {
        Employee employee = employeeRepository.findByName("zhangsan");

        System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
    }


    /**
     * 测试EntityManagerFactory
     */
    @Test
    public void testFindByNameStartingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test",25);
        for (Employee employee:employees) {
            System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
        }
    }

    /**
     * 测试EntityManagerFactory
     */
    @Test
    public void testFindByNameEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6",22);
        for (Employee employee:employees) {
            System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
        }
    }


    @Test
    public void testFindByNameInOrAgeLessThan() {

        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names,22);
        for (Employee employee:employees) {
            System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
        }
    }

    @Test
    public void testFindByNameInAndAgeLessThan() {

        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names,22);
        for (Employee employee:employees) {
            System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
        }
    }




    @Test
    public void testGetEmployeeMaxId() {

        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        Employee employee = employeeRepository.getEmployeeMaxId();

            System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
    }

    @Test
    public void testQueryParams1() {

        List<Employee>  employees = employeeRepository.queryParams1(22,"test2");
        for (Employee employee:employees) {
            System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
        }
    }


    @Test
    public void testQueryParams2() {

        List<Employee>  employees = employeeRepository.queryParams2(22,"test2");
        for (Employee employee:employees) {
            System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
        }
    }



    @Test
    public void testQueryLike1() {

        List<Employee>  employees = employeeRepository.queryLike1("test1");
        for (Employee employee:employees) {
            System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
        }
    }


    @Test
    public void testQueryLike2() {

        List<Employee>  employees = employeeRepository.queryLike2("test1");
        for (Employee employee:employees) {
            System.out.println("id: " + employee.getId() + " ,name: " + employee.getName() + " ,age: " + employee.getAge());
        }
    }



    @Test
    public void testGetCount() {
        employeeRepository.updateEmployee(1,60);
    }




    @After
    public void tearContext() {
        context = null;
        System.out.println("tearContext");
    }

}
