package com.gdgm.stu.service;

import java.util.List;

import com.gdgm.stu.pojo.*;

public interface stu_service {
	
	//学生管理
	public List<student> student(student s);
	
	//学生管理--年度下拉框显示全部年度类型
	public List<student> student_year_type();
	
	//学生管理--级别下拉框显示全部级别类型
	public List<stu_grade> stu_grade_type();
	//学生管理--级别下拉框显示全部班别类型
	public List<stu_class> stu_class_type();
	
	//分页--获得数目符合条件的学生总行数count_page
	public int student_count(student s);
	
	//学生管理--修改学生信息
	public void student_update(student s);
	//学生管理--删除学生信息
	public void student_delete(String s);
	//学生管理--插入学生信息
	public void student_insert(student s);
	//学生管理--插入学生信息--判断学号是否已经存在
	public int student_alike(student s);
	
	void updateItem(images item);
}
