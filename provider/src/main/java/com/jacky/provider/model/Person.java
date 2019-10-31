package com.jacky.provider.model;

/**
 * @Authror jacky
 * @create 2019-10-31
 */

public class Person {
    private Integer id;

    private String name;

    private Integer age;

    private String message;

    public Person() {
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(Integer id, String name, Integer age, String message) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
