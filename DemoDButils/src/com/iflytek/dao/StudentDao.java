package com.iflytek.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.iflytek.domain.Student;
import com.iflytek.util.C3P0Util;

public class StudentDao {
	
	/**
	 * DBUtils的数据库操作类
	 */
	private QueryRunner qr;
	
	
	/**
	 * 创建数据库操作类
	 */
	public StudentDao(){
		qr = new QueryRunner(C3P0Util.getDataSource());
	}
	
	
	
	// 添加
	public void addStudent(String name , int  age , String sex )throws Exception{
		String sql = "insert into t_student(name,age,sex) values(?,?,?)";
		qr.update(sql,name,age,sex);

	}
	
	
	// 删除
	public void deleteStudent(int id)throws Exception{
		String sql = "delete from t_student where id = ?";
		qr.update(sql  , id);
	}
	
	
	
	// 修改
	public void updateStudent(String name , int age, String sex , int id)throws Exception{
		String sql = "update t_student set name = ? , age = ?,sex = ? where id = ?";
		qr.update(sql , name , age , sex , id);
	}
	
	
	
	
	// 查询   需要BeanHandler  我下周会讲解这个
	public Student getStudentById(int id) throws Exception{
		String sql = "select * from t_student where id = ?";
		Student result = qr.query(sql, new BeanHandler<>(Student.class) , id);
		return result;
	}
	
	
	// 查询所有  需要BeanListHandler    我下周会讲解这个
	public List<Student> queryAll() throws Exception{
		String sql =  "select * from t_student";
		return qr.query(sql, new BeanListHandler<>(Student.class));
	}
	
	
	
}
