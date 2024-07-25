package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService();

    public void start() {
        Scanner sc = new Scanner(System.in);
        studentLoop:
        while (true) {
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    //System.out.println("添加学生");
                    addStudent();
                    break;
                case "2":
                    //System.out.println("删除学生");
                    deleteStudentById();
                    break;
                case "3":
                    //System.out.println("修改学生");
                    updateStudent();
                    break;
                case "4":
                    //System.out.println("查看学生");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢您的使用");
                    break studentLoop;
                default:
                    System.out.println("您的输入有误, 请重新输入");
                    break;
            }
        }
    }

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        String updateId;
        while (true) {
            System.out.println("请输入要修改的id:");
            updateId = sc.next();
            if (studentService.isEXist(updateId)){
                break;
            }else {
                System.out.println("此用户不存在, 请重新输入!");
            }
        }
        Student student = new Student();
        student.setId(updateId);
        System.out.println("请输入要更改的姓名:");
        student.setName(sc.next());
        System.out.println("请输入要更改的年龄:");
        student.setAge(sc.next());
        System.out.println("请输入要更改的生日:");
        student.setBirthday(sc.next());
        //将数据传给service
        studentService.updateStudent(updateId,student);
        System.out.println("修改成功!");
    }

    public void deleteStudentById() {
        String delId;
        //通知业务员 得到学生对象数组
        Student[] student = studentService.findfindAllStudent();
        //检查学生对象数组是不是null 先假设是null
        boolean notNull = false;
        if (student != null) {
            notNull = true;
        }
        if (!notNull) {
            System.out.println("暂无信息,请添加后重试!");
            return;
        }

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您要删除的ID:");
            //从键盘读取对象
            delId = sc.next();
            //
            if (!studentService.isEXist(delId)) {
                System.out.println("您输入的ID不存在,请重新输入!");
            } else {
                break;
            }
        }
        //将要删除的ID传递的业务员
        studentService.deleteStudentById(delId);
        //提示删除成功
        System.out.println("删除成功!");

    }

    public void findAllStudent() {
        //通知业务员 得到学生对象数组
        Student[] student = studentService.findfindAllStudent();
        //检查学生对象数组是不是null 先假设是null
        boolean notNull = false;
        if (student != null) {
            notNull = true;
        }
        //如果不是空的 循环打印
        if (notNull) {
            System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t\t生日");
            for (int i = 0; i < student.length; i++) {
                Student stu = student[i];
                if (stu != null) {
                    System.out.println(stu.getId() + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getBirthday());
                }
            }
        } else {
            System.out.println("查无信息,请添加后重试");
        }
    }


    void addStudent() {
        //创建StudentService的一个对象
        //从键盘接收要增加学生的信息
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入学生ID:");
            id = sc.next();
            if (studentService.isEXist(id)) {
                System.out.println("这个ID已存在,请重新输入");
            } else {
                break;
            }
        }
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        String age = sc.next();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();
        //把这些信息封装成学生类
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        //把这个对象传给StudentService类里的addStudent()方法.
        boolean result = studentService.addStudent(stu);
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
}
