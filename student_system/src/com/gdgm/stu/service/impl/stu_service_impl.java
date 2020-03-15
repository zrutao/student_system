package com.gdgm.stu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdgm.stu.service.stu_service;
import com.gdgm.stu.mapper.dao_stu;
import com.gdgm.stu.pojo.images;
import com.gdgm.stu.pojo.stu_class;
import com.gdgm.stu.pojo.stu_grade;
import com.gdgm.stu.pojo.student;

@Service
public class stu_service_impl implements stu_service {

	@Autowired
	private dao_stu dao_s;
	//学生管理
	@Override
	public List<student> student(student s) {
		// TODO Auto-generated method stub
		return dao_s.student(s);
	}
	//学生管理--级别下拉框显示全部级别类型
	@Override
	public List<stu_grade> stu_grade_type() {
		// TODO Auto-generated method stub
		return dao_s.stu_grade_type();
	}
	//学生管理--级别下拉框显示全部班别类型
	@Override
	public List<stu_class> stu_class_type() {
		// TODO Auto-generated method stub
		return dao_s.stu_class_type();
	}
	//学生管理--修改学生信息
	@Override
	public void student_update(student s) {
		// TODO Auto-generated method stub
		dao_s.student_update(s);
	}
	//学生管理--删除学生信息
	@Override
	public void student_delete(String s) {
		// TODO Auto-generated method stub
		dao_s.student_delete(s);
	}
	//学生管理--插入学生信息
	@Override
	public void student_insert(student s) {
		// TODO Auto-generated method stub
		dao_s.student_insert(s);
	}
	//学生管理--插入学生信息--判断学号是否已经存在
	@Override
	public int student_alike(student s) {
		// TODO Auto-generated method stub
		return dao_s.student_alike(s);
	}
	//分页--获得数目符合条件的学生总行数count_page
	@Override
	public int student_count(com.gdgm.stu.pojo.student s) {
		// TODO Auto-generated method stub
		return dao_s.student_count(s);
	}
	@Override
	public void updateItem(images item) {
		// TODO Auto-generated method stub
		dao_s.updateItem(item);
	}
	@Override
	public List<com.gdgm.stu.pojo.student> student_year_type() {
		// TODO Auto-generated method stub
		return dao_s.student_year_type();
	}
	
}
