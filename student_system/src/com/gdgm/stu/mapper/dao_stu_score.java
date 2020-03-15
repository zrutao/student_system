package com.gdgm.stu.mapper;

import java.util.List;

import com.gdgm.stu.pojo.login_admin;
import com.gdgm.stu.pojo.stu_score;

public interface dao_stu_score {
	//登录验证
	public int login_count(login_admin log);
	//记录访问IP
	public void visit(login_admin login_visit);
	
	//分页--获得数目符合条件的学生总行数count_page
	public int student_count(stu_score s);
	//学生管理
	public List<stu_score> score(stu_score s);
}
