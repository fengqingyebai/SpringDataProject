package com.link.domain;


import javax.persistence.*;

/**
 * 注解员工表
 *
 * @author link
 * @create 2018-04-06-12:00
 */
/**
 * 雇员:  先开发实体类===>自动生成数据表
 */
@Entity
@Table(name="crud_employee")
public class Employee {
    private Integer id;

    private String name;

    private Integer age;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
