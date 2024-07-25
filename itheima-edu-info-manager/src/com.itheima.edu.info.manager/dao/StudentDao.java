package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

public class StudentDao {
    private static Student[] stus = new Student[5];

    public boolean addStudent(Student stu) {
        //创建学生对象数组
        //找到null元素在哪,就找到了数组的哪个元素是空的
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            if (stus[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        } else {
            stus[index] = stu;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentByid(String delId) {
        int index = getIndex(delId);
        stus[index] = null;
    }

    public int getIndex(String delId){
        //先假设index不存在
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student != null && student.getId().equals(delId)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String updateId, Student student) {
        int index = getIndex(updateId);
        stus[index] = student;
    }
}
