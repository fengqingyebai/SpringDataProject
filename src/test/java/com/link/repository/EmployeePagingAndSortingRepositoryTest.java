package com.link.repository;

import com.link.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * Created by IntelliJ IDEA.
 * User: link
 * Date: 2018/4/9
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */
public class EmployeePagingAndSortingRepositoryTest {

    private ApplicationContext context = null;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository = null;

    @Before
    public void setContext() {
        context = new ClassPathXmlApplicationContext("bean-new.xml");
        employeePagingAndSortingRepository = context.getBean(EmployeePagingAndSortingRepository.class);
        System.out.println("setContext");
    }


    @After
    public void tearContext() {
        context = null;
        System.out.println("tearContext");
    }


    @Test
    public void testPage() {
        //page,从0开始 size每页的显示数
        Pageable pageable = new PageRequest(1,9);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);


        System.out.println("分页结果总页数:"+page.getTotalPages());
        System.out.println("分页结果总条数:"+page.getTotalElements());
        System.out.println("分页结果当前第几页:"+(page.getNumber()+1));
        System.out.println("分页结果当前页元素:"+page.getContent());
        System.out.println("分页结果当前页元素个数:"+page.getNumberOfElements());




    }


    @Test
    public void testSort() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        //page,从0页开始 size每页的显示数
        Pageable pageable = new PageRequest(0,5,sort);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);


        System.out.println("分页结果总页数:"+page.getTotalPages());
        System.out.println("分页结果总条数:"+page.getTotalElements());
        System.out.println("分页结果当前第几页:"+(page.getNumber()+1));
        System.out.println("分页结果当前页元素:"+page.getContent());
        System.out.println("分页结果当前页元素个数:"+page.getNumberOfElements());




    }


}
