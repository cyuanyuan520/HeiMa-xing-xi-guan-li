package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.TeacherDao;
import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherService {
    private TeacherDao teacherDao = new TeacherDao();

    public boolean addTeacher(Teacher stu) {
        //继续传递信息给TeacherDao
        //返回boolean类型给TeacherController
        return teacherDao.addTeacher(stu);
    }

    public boolean isEXist(String id) {
        Teacher[] stus = teacherDao.findAllTeacher();
        //假设不存在
        boolean exists = false;
        //遍历数组
        for (int i = 0; i < stus.length; i++) {
            Teacher teacher = stus[i];
            if (teacher != null && teacher.getId().equals(id))
            {
                exists = true;
                break;
            }
        }
        return exists;
    }


    public Teacher[] findfindAllTeacher() {
        //找库管DAO拿学生数据
        Teacher[] allTeacher = teacherDao.findAllTeacher();
        //查看是不是空的 假设刚开始全是空的
        boolean notNull = false;
        for (int i = 0; i < allTeacher.length; i++) {
            Teacher teacher = allTeacher[i];
            if (teacher != null){
                notNull = true;
                break;
            }
        }
        if (notNull){
            return allTeacher;
        } else {
            return null;
        }
    }

    public void deleteTeacherById(String delId) {
        teacherDao.deleteTeacherByid(delId);
    }

    public void updateTeacher(String updateId, Teacher teacher) {
        teacherDao.updateTeacher(updateId,teacher);
    }
}
