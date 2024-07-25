package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.StudentDao;
import com.itheima.edu.info.manager.domain.Student;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public boolean addStudent(Student stu) {
        //继续传递信息给StudentDao
        //返回boolean类型给StudentController
        return studentDao.addStudent(stu);
    }

    public boolean isEXist(String id) {
        Student[] stus = studentDao.findAllStudent();
        //假设不存在
        boolean exists = false;
        //遍历数组
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student != null && student.getId().equals(id))
            {
                exists = true;
                break;
            }
        }
        return exists;
    }


    public Student[] findfindAllStudent() {
        //找库管DAO拿学生数据
        Student[] allStudent = studentDao.findAllStudent();
        //查看是不是空的 假设刚开始全是空的
        boolean notNull = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student student = allStudent[i];
            if (student != null){
                notNull = true;
                break;
            }
        }
        if (notNull){
            return allStudent;
        } else {
            return null;
        }
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentByid(delId);
    }

    public void updateStudent(String updateId, Student student) {
        studentDao.updateStudent(updateId,student);
    }
}
