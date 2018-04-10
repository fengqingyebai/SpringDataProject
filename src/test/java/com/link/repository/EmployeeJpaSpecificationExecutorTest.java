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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;


/**
 * Created by IntelliJ IDEA.
 * User: link
 * Date: 2018/4/9
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeJpaSpecificationExecutorTest {

    private ApplicationContext context = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;

    @Before
    public void setContext() {
        context = new ClassPathXmlApplicationContext("bean-new.xml");
        employeeJpaSpecificationExecutorRepository = context.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setContext");
    }


    @After
    public void tearContext() {
        context = null;
        System.out.println("tearContext");
    }


    /**
     * 1）查询
     * 2）分页
     */
    @Test
    public void testQuery() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        //page,从0页开始 size每页的显示数
        Pageable pageable = new PageRequest(0, 5, sort);

        /**
         * root 代表employee query 代表查询条件 criteriaBuilder代表构建
         */
        Specification specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {

                Path path = root.get("age");

                return criteriaBuilder.gt(path, 50);
            }
        };


        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);


        System.out.println("分页结果总页数:" + page.getTotalPages());
        System.out.println("分页结果总条数:" + page.getTotalElements());
        System.out.println("分页结果当前第几页:" + (page.getNumber() + 1));
        System.out.println("分页结果当前页元素:" + page.getContent());
        System.out.println("分页结果当前页元素个数:" + page.getNumberOfElements());


    }


}
