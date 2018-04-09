package com.link.repository;


import com.link.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 员工的数据访问组件接口
 *
 * @author link
 * @create 2018-04-08-23:04
 */
@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository  {//extends Repository<Employee,Integer> {


  public Employee findByName(String name);
//where name like ?% and age<?
  public List<Employee> findByNameStartingWithAndAgeLessThan(String name,Integer age);
  //where name like %? and age<?
  public List<Employee> findByNameEndingWithAndAgeLessThan(String name,Integer age);

  //where name in (?,？，？..) or age<?
  public List<Employee> findByNameInOrAgeLessThan(List<String> names,Integer age);

  //where name in (?,？，？..) and age<?
  public List<Employee> findByNameInAndAgeLessThan(List<String> names,Integer age);

  @Query("select o from Employee o where o.id=(select count(o.id) from Employee o )")
  public Employee getEmployeeMaxId();

  @Query("select o from Employee o where o.age=?1 and o.name=?2")
  public List<Employee>  queryParams1(Integer age,String name);


  @Query("select o from Employee o where o.age=:age and o.name=:name")
  public List<Employee>  queryParams2(@Param("age") Integer age, @Param("name") String name);

  @Query("select o from Employee o where o.name like %?1%")
  public List<Employee>  queryLike1(String name);


  @Query("select o from Employee o where o.name like %:name%")
  public List<Employee>  queryLike2(@Param("name") String name);


  @Query(nativeQuery =true,value = "select count(1) from employee")
  public Long getCount();

  @Modifying
  @Query("update Employee o set o.age = :age where o.id=:id ")
  void updateEmployee(@Param("id") Integer id,@Param("age") Integer age);


  @Modifying
  @Query("delete  from Employee o where o.id=:id ")
  void deleteEmployee(@Param("id") Integer id);

}
