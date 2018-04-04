package com.link.domain;


/**
 * student实体类即对象模型
 *
 * @author link
 * @create 2018-04-03-23:45
 */
public class Student {

    /**
     * 主键字段
      */
    private int id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private  int age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
