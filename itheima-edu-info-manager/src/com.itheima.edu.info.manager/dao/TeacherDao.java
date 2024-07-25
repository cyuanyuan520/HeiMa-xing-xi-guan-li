package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherDao {
    private static Teacher[] stus = new Teacher[5];

    public boolean addTeacher(Teacher stu) {
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

    public Teacher[] findAllTeacher() {
        return stus;
    }

    public void deleteTeacherByid(String delId) {
        int index = getIndex(delId);
        stus[index] = null;
    }

    public int getIndex(String delId){
        //先假设index不存在
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Teacher teacher = stus[i];
            if (teacher != null && teacher.getId().equals(delId)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateTeacher(String updateId, Teacher teacher) {
        int index = getIndex(updateId);
        stus[index] = teacher;
    }
}
