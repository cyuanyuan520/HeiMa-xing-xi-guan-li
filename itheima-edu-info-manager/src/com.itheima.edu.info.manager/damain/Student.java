package com.itheima.edu.info.manager.domain;

public class Student {
    private String id;
    private String name;
    private String age;
    private String birthday;

    //无参构造方法
    public Student() {
    }
    //全参构造方法
    public Student(String id, String name,String age,String birthday){
        this.id=id;
        this.name = name;
        this.age= age;
        this.birthday = birthday;
    }
    //get函数和set函数
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAge(){
        return this.age;
    }
    public void setAge(String age){
        this.age = age;
    }
    public String getBirthday(){
        return this.birthday;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

}
