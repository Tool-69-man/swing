package com.iflytek.test;

import java.util.List;

import com.iflytek.dao.StudentDao;
import com.iflytek.domain.Student;

public class DBUtilsTest {
	public static void main(String[] args) throws Exception {
		
		// 创建t_student学生表的数据库操作类
		StudentDao sd = new StudentDao();
		
		// 添加数据库测试
		sd.addStudent("周六", 22, "男");
		System.out.println("成功");
		
		// 更新数据库测试
		sd.updateStudent("周六2", 23, "女", 4);
//		System.out.println("成功");
		
		
		// 删除数据库测试
		sd.deleteStudent(4);
//		System.out.println("成功");
		
		// 查询所有测试
		List<Student> list = sd.queryAll();
		for (Student s : list) {
			System.out.println(s);
		}
		
		// 根据ID查询学生 测试
		Student s = sd.getStudentById(3);
		System.out.println(s);
		
		
		
		
		
		
		
		
		
		
		
	}
}
