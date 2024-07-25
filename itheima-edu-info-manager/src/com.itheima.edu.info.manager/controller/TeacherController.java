package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Teacher;
import com.itheima.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private TeacherService teacherService = new TeacherService();

    public void start() {
        Scanner sc = new Scanner(System.in);
        teacherLoop:
        while (true) {
            System.out.println("--------欢迎来到 <教师> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加教师  2.删除教师  3.修改教师  4.查看教师  5.退出");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    //System.out.println("添加教师");
                    addTeacher();
                    break;
                case "2":
                    //System.out.println("删除教师");
                    deleteTeacherById();
                    break;
                case "3":
                    //System.out.println("修改教师");
                    updateTeacher();
                    break;
                case "4":
                    //System.out.println("查看教师");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢您的使用");
                    break teacherLoop;
                default:
                    System.out.println("您的输入有误, 请重新输入");
                    break;
            }
        }
    }

    public void updateTeacher() {
        Scanner sc = new Scanner(System.in);
        String updateId;
        while (true) {
            System.out.println("请输入要修改的id:");
            updateId = sc.next();
            if (teacherService.isEXist(updateId)){
                break;
            }else {
                System.out.println("此用户不存在, 请重新输入!");
            }
        }
        Teacher teacher = new Teacher();
        teacher.setId(updateId);
        System.out.println("请输入要更改的姓名:");
        teacher.setName(sc.next());
        System.out.println("请输入要更改的年龄:");
        teacher.setAge(sc.next());
        System.out.println("请输入要更改的生日:");
        teacher.setBirthday(sc.next());
        //将数据传给service
        teacherService.updateTeacher(updateId,teacher);
        System.out.println("修改成功!");
    }

    public void deleteTeacherById() {
        String delId;
        //通知业务员 得到教师对象数组
        Teacher[] teacher = teacherService.findfindAllTeacher();
        //检查教师对象数组是不是null 先假设是null
        boolean notNull = false;
        if (teacher != null) {
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
            if (!teacherService.isEXist(delId)) {
                System.out.println("您输入的ID不存在,请重新输入!");
            } else {
                break;
            }
        }
        //将要删除的ID传递的业务员
        teacherService.deleteTeacherById(delId);
        //提示删除成功
        System.out.println("删除成功!");

    }

    public void findAllTeacher() {
        //通知业务员 得到教师对象数组
        Teacher[] teacher = teacherService.findfindAllTeacher();
        //检查教师对象数组是不是null 先假设是null
        boolean notNull = false;
        if (teacher != null) {
            notNull = true;
        }
        //如果不是空的 循环打印
        if (notNull) {
            System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t\t生日");
            for (int i = 0; i < teacher.length; i++) {
                Teacher stu = teacher[i];
                if (stu != null) {
                    System.out.println(stu.getId() + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getBirthday());
                }
            }
        } else {
            System.out.println("查无信息,请添加后重试");
        }
    }


    void addTeacher() {
        //创建TeacherService的一个对象
        //从键盘接收要增加教师的信息
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入教师ID:");
            id = sc.next();
            if (teacherService.isEXist(id)) {
                System.out.println("这个ID已存在,请重新输入");
            } else {
                break;
            }
        }
        System.out.println("请输入教师姓名:");
        String name = sc.next();
        System.out.println("请输入教师年龄:");
        String age = sc.next();
        System.out.println("请输入教师生日:");
        String birthday = sc.next();
        //把这些信息封装成教师类
        Teacher stu = new Teacher();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        //把这个对象传给TeacherService类里的addTeacher()方法.
        boolean result = teacherService.addTeacher(stu);
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
}
